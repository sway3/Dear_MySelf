package com.Yongjun.Rolling_paper.controller;

import com.Yongjun.Rolling_paper.domain.entity.LetterEntity;
import com.Yongjun.Rolling_paper.domain.repository.LetterRepository;
import com.Yongjun.Rolling_paper.dto.LetterDto;
import com.Yongjun.Rolling_paper.dto.MemberDto;
import lombok.AllArgsConstructor;
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
public class LetterController {
    private LetterRepository letterRepository;

    @GetMapping("/write")
    public String createLetter(Model model) {
        model.addAttribute("letterDto", new LetterDto());
        return "/LetterWriting";
    }
    @PostMapping
    public String submitLetterForm(@ModelAttribute("letter") LetterDto letterModel) {
        LetterEntity letter = new LetterEntity();
        letter.setContent(letterModel.getContent());
        letter.setFont(letterModel.getFont());
        letter.setPaper(letterModel.getPaper());
        letterRepository.save(letter);
        return "redirect:/";
    }
    @GetMapping("/{id}")
    public LetterEntity getLetterById(@PathVariable Long id) {
        return letterRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Letter not found"));
    }

    // Other controller methods for updating, deleting, and listing letters
}
