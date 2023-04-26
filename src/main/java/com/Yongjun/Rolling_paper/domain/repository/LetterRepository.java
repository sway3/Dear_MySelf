package com.Yongjun.Rolling_paper.domain.repository;

import com.Yongjun.Rolling_paper.domain.entity.Letter;
import com.Yongjun.Rolling_paper.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
public interface LetterRepository extends JpaRepository<Letter, Long> {
    @Override
    Optional<Letter> findById(Long aLong);

    List<Letter> findAllByMember(Member member);


}
