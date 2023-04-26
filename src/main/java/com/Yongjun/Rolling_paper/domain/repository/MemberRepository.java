package com.Yongjun.Rolling_paper.domain.repository;

import com.Yongjun.Rolling_paper.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
}
