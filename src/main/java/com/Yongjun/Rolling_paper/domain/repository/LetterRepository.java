package com.Yongjun.Rolling_paper.domain.repository;

import com.Yongjun.Rolling_paper.domain.entity.Letter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface LetterRepository extends JpaRepository<Letter, Long> {
    @Override
    Optional<Letter> findById(Long aLong);

}
