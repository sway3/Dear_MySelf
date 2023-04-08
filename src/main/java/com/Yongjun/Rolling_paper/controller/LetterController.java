package com.Yongjun.Rolling_paper.controller;

import com.Yongjun.Rolling_paper.domain.entity.MyHotel;
import com.Yongjun.Rolling_paper.service.LetterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LetterController {

    private final LetterService letterService;

    @GetMapping("/createLink")
    public String generateLink() {
        String randomLink = UUID.randomUUID().toString();
        log.info(randomLink + "   랜덤 링크");
//        return "http://localhost:8080/post/" + randomLink;
        return "redirect:/";
    }
    @GetMapping("/post/{link}")
    public String showPostForm(@PathVariable("link") String link, Model model) {
        Optional<MyHotel> optionalMyHotel = letterService.findByLink(link);
        if (optionalMyHotel.isPresent()) {
            model.addAttribute("myHotel", optionalMyHotel.get());
        } else {
            MyHotel myHotel = new MyHotel();
            myHotel.setLink(link);
            model.addAttribute("myHotel", myHotel);
        }
        return "postForm";
    }

    @PostMapping("/savePost")
    public String savePost(@RequestParam("link") String link, @RequestParam("content") String content) {
        log.info("글 작성");
        letterService.savePost(link, content);
        return "redirect:/";
    }
}