package com.Yongjun.Rolling_paper.domain.repository;

import com.Yongjun.Rolling_paper.domain.entity.MemberEntity;
import com.Yongjun.Rolling_paper.domain.entity.MyHotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LetterRepository extends JpaRepository<MyHotel, Long> {
    Optional<MyHotel> findByLink(String link);
}
