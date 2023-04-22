package com.Yongjun.Rolling_paper.domain.repository;

import com.Yongjun.Rolling_paper.domain.entity.LetterEntity;
import com.Yongjun.Rolling_paper.domain.entity.MemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
public interface LetterRepository extends JpaRepository<LetterEntity, Long> {
    @Override
    Optional<LetterEntity> findById(Long aLong);

}
