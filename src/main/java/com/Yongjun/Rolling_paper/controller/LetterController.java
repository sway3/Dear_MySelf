package com.Yongjun.Rolling_paper.controller;

import com.Yongjun.Rolling_paper.domain.entity.LetterEntity;
import com.Yongjun.Rolling_paper.domain.entity.MemberEntity;
import com.Yongjun.Rolling_paper.domain.repository.LetterRepository;
import com.Yongjun.Rolling_paper.dto.LetterDto;
import com.Yongjun.Rolling_paper.dto.MemberDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@Controller
@RequestMapping("/letter")
@AllArgsConstructor
@Slf4j
public class LetterController {
    private LetterRepository letterRepository;

    @GetMapping("/write")
    public String createLetter(Model model) {
        model.addAttribute("letterDto", new LetterDto());
        return "/LetterWriting";
    }
    @PostMapping
    public String submitLetterForm(@ModelAttribute("letter") LetterDto letterModel, MemberEntity memberDto) {
        LetterEntity letter = new LetterEntity();
        letter.setContent(letterModel.getContent());
        letter.setFont(letterModel.getFont());
        letter.setPaper(letterModel.getPaper());
        letter.setTitle(letterModel.getTitle());
//        letter.setWriter(memberDto.getName());
//        로그인을 하면 사용자의 이름을 가져오도록 한다.
        log.info(memberDto.getName());
        letterRepository.save(letter);
        return "redirect:/";
    }
    @GetMapping("/{id}")
    public LetterEntity getLetterById(@PathVariable Long id) {
        return letterRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Letter not found"));
    }

    // Other controller methods for updating, deleting, and listing letters
}
