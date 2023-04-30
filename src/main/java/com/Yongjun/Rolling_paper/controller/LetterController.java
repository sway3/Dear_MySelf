package com.Yongjun.Rolling_paper.controller;

import com.Yongjun.Rolling_paper.domain.entity.Letter;
import com.Yongjun.Rolling_paper.domain.entity.Member;
import com.Yongjun.Rolling_paper.domain.repository.LetterRepository;
import com.Yongjun.Rolling_paper.domain.repository.MemberRepository;
import com.Yongjun.Rolling_paper.dto.LetterDto;
import com.Yongjun.Rolling_paper.service.LetterService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/letter")
@AllArgsConstructor
@Slf4j
public class LetterController {
    private LetterRepository letterRepository;
    private MemberRepository memberRepository;
    private LetterService letterService;


    @GetMapping("/write")
    public String createLetter(Model model, Principal principal) throws IOException {
        if (principal == null) {
            return "redirect:/login"; // 로그인 페이지로 돌려줌
        }
        model.addAttribute("letterDto", new LetterDto());
        return "/LetterWriting";
    }

    @PostMapping("/write")
    public String submitLetterForm(@ModelAttribute LetterDto letterModel, Principal principal) {
//        letterModel.setContent(letterModel.getContent());
//        letterModel.setFont(letterModel.getFont());
//        letterModel.setPaper(letterModel.getPaper());
//        letterModel.setTitle(letterModel.getTitle());
        letterModel.setWriter(principal.getName());
//        로그인을 하면 사용자의 이름을 가져오도록 한다.
        Member member = memberRepository.findByEmail(principal.getName()).orElseThrow(() -> new EntityNotFoundException("Member not found"));
        letterModel.setMember(member); // Member 정보를 넣어줌
        log.info(principal.getName());
        letterService.save(letterModel);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public Letter getLetterById(@PathVariable Long id) {
        return letterRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Letter not found"));
    }

    @GetMapping("/letters")
    public String getLetters(Model model, Principal principal) {
        Member member = memberRepository.findByEmail(principal.getName()).orElseThrow(() -> new EntityNotFoundException("Member not found"));
        List<Letter> letters = letterRepository.findAllByMember(member);
        model.addAttribute("letters", letters);
        return "/letters";
    }


    @GetMapping("/detail/{id}")
    public String getDetails(Model model, @PathVariable Long id) {
        Letter letter = letterRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Letter not found"));
        model.addAttribute("letterEntity", letter);
        return "/CurrentLetter";
    }


    // Other controller methods for updating, deleting, and listing letters
}
