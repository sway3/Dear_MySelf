package com.Yongjun.Rolling_paper.service;

import com.Yongjun.Rolling_paper.domain.entity.MyHotel;
import com.Yongjun.Rolling_paper.domain.repository.LetterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class LetterService {
    private final LetterRepository letterRepository;
    private static final String LINK_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int LINK_LENGTH = 10;

    public String generateRandomLink() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < LINK_LENGTH; i++) {
            sb.append(LINK_CHARS.charAt(random.nextInt(LINK_CHARS.length())));
        }
        return sb.toString();
    }


    public void savePost(String link, String content) {
        MyHotel myHotel = new MyHotel(link, content);
        letterRepository.save(myHotel);
    }
    public Optional<MyHotel> findByLink(String link) {
        return letterRepository.findByLink(link);
    }
}