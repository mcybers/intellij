package com.springapp.mvc.repository;

import com.springapp.mvc.domain.Member;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;



/**
 * Created by n on 2015-12-22.
 */
@Repository
public class MemberRepository {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void save(Member member) {
        em.persist(member);
    }

    @Transactional(readOnly = true)
    public Member findOne(String id) {

        return em.find(Member.class, id);
    }
//
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

}