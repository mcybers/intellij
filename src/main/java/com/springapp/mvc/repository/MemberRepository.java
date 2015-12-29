package com.springapp.mvc.repository;

import com.springapp.mvc.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by n on 2015-12-29.
 */

public interface MemberRepository extends JpaRepository<Member, String> {
    List<Member> findByName(String name);
}
