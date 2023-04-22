package com.Yongjun.Rolling_paper.service;

import com.Yongjun.Rolling_paper.domain.entity.LetterEntity;
import com.Yongjun.Rolling_paper.domain.entity.MemberEntity;
import com.Yongjun.Rolling_paper.domain.repository.LetterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LetterService {
    private final LetterRepository letterRepository;

    public LetterService(LetterRepository letterRepository) {
        this.letterRepository = letterRepository;
    }


    public LetterEntity save(LetterEntity letterEntity) {
        return letterRepository.save(letterEntity);
    }
}