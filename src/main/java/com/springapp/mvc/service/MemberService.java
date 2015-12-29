package com.springapp.mvc.service;

import com.springapp.mvc.domain.Member;
import com.springapp.mvc.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.*;
import java.util.List;

import java.security.SecureRandom;


/**
 * User: HolyEyE
 * Date: 2013. 12. 3. Time: 오전 1:07
 */
@Service
@Transactional
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    // 소금 치기
    public byte[] salting(byte[] salt, byte[] password) {
        byte[] salting = new byte[salt.length + password.length];
        System.arraycopy(salt, 0, salting, 0, salt.length);
        System.arraycopy(password, 0, salting, salt.length, password.length);
        return salting;
    }

    // 소금값 생성
    public byte[] createSalt() throws NoSuchAlgorithmException {
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = secureRandom.generateSeed(10);
        return salt;
    }

    //해쉬 값 생성
    public byte[] createHash(byte[] salting) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(salting);
        byte[] diegest = md5.digest();
        return diegest;
    }

    //회원 가입
    public String join(Member member) throws NoSuchAlgorithmException {

        validateDuplicateMember(member); //중복 회원 검증

        byte[] salt = createSalt();
        member.setSalt(salt);
        byte[] password = member.getPassword();
        byte[] salting = salting(salt, password);
        byte[] digest = createHash(salting);
        member.setPassword(digest);

        memberRepository.save(member);
        return member.getId();
    }

    //중복된 ID 검색
    private void validateDuplicateMember(Member member) {
        Member mem = memberRepository.findOne(member.getId());
        if (mem != null) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    //전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    //ID에 해당하는 값 가져오기
    public Member findOne(String memberId) {
        return memberRepository.findOne(memberId);
    }

    public List<Member> findByName(String name){
        return memberRepository.findByName(name);
    }

    public boolean login(Member member) throws NoSuchAlgorithmException {

        boolean result = false;

        Member foundMember = findOne(member.getId());
        if (foundMember == null) {
            return false;
        }
        ;
        byte[] salting = salting(foundMember.getSalt(), member.getPassword());
        byte[] digest = createHash(salting);
        byte[] foundDigest = foundMember.getPassword();

        System.out.println();
        if (MessageDigest.isEqual(digest, foundDigest)) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }


    public void modify(Member member) throws NoSuchAlgorithmException {

        Member foundMember = memberRepository.findOne(member.getId());
        byte[] digest = createHash(salting(foundMember.getSalt(), member.getPassword()));
        foundMember.setName(member.getName());
        foundMember.setPassword(digest);

    }


}
