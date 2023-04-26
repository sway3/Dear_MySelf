package com.Yongjun.Rolling_paper.controller;


import com.Yongjun.Rolling_paper.dto.MemberDto;
import com.Yongjun.Rolling_paper.service.MemberService;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import javassist.bytecode.DuplicateMemberException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.parser.JSONParser;
import org.springframework.boot.json.JsonParseException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
@Slf4j
public class MemberController {
    private MemberService memberService;


    // 메인 페이지
//    @GetMapping("/")
//    public String index() {
//        return "/index";
//
    @GetMapping("/")
    public String home(Model model, HttpServletRequest request) {
        // 세션에서 사용자 정보를 가져옵니다.
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        // 사용자가 로그인되어 있지 않으면 로그인 버튼을 표시합니다.
        if (principal instanceof String) {
            model.addAttribute("loggedIn", false);
        }
        // 사용자가 로그인되어 있으면 사용자 정보와 로그아웃 버튼을 표시합니다.
        else if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            model.addAttribute("loggedIn", true);
            model.addAttribute("username", username);
        }

        return "/index";
    }

    // 회원가입 페이지
    @GetMapping("/user/signup")
    public String dispSignup(Model model) {
        model.addAttribute("memberDto", new MemberDto());
        return "/signup";
    }

    // 회원가입 처리
    @PostMapping("/user/signup")
    public String execSignup(@Valid MemberDto memberDto, BindingResult result) throws DuplicateMemberException {
        if (result.hasErrors()) {
            log.info("틀렸습니다.");
            return "/signup";
        }
        memberService.joinUser(memberDto);

        return "redirect:/";
    }
    // 로그아웃 처리
    @GetMapping("/logout")
    public String execLogout(HttpServletRequest request) {
        // SecurityContext를 가져와서 인증 정보를 삭제합니다.
        SecurityContextHolder.clearContext();
        // 세션을 무효화합니다.
        request.getSession().invalidate();
        // 로그인 페이지로 리다이렉트합니다.
        return "redirect:/";
    }

    // 로그인 페이지
    @GetMapping("/user/login")
    public String dispLogin() {
        return "/login";
    }

    // 로그인 결과 페이지
    @GetMapping("/user/login/result")
    public String dispLoginResult() {
        return "redirect:/";
    }

    // 로그아웃 결과 페이지
    @GetMapping("/user/logout/result")
    public String dispLogout() {
        return "/logout";
    }

    // 접근 거부 페이지
    @GetMapping("/user/denied")
    public String dispDenied() {
        return "/denied";
    }

    // 내 정보 페이지
//    @GetMapping("/user/info")
//    public String dispMyInfo() {
//        return "/myinfo";
//    }

    // 어드민 페이지
    @GetMapping("/admin")
    public String dispAdmin() {
        return "/admin";
    }
}
