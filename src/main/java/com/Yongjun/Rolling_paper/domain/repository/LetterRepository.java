package com.Yongjun.Rolling_paper.domain.repository;

import com.Yongjun.Rolling_paper.domain.entity.LetterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface LetterRepository extends JpaRepository<LetterEntity, Long> {
    @Override
    Optional<LetterEntity> findById(Long aLong);
}
