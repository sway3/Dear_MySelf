package com.Yongjun.Rolling_paper.service;

import com.Yongjun.Rolling_paper.domain.entity.Letter;
import com.Yongjun.Rolling_paper.domain.repository.LetterRepository;
import com.Yongjun.Rolling_paper.dto.LetterDto;
import org.springframework.stereotype.Service;

@Service
public class LetterService {
    private final LetterRepository letterRepository;

    public LetterService(LetterRepository letterRepository) {
        this.letterRepository = letterRepository;
    }


    public Letter save(LetterDto letterDto) {

        return letterRepository.save(letterDto.toEntity());
    }
}