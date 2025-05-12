package com.luminous.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.luminous.domain.Member;
import com.luminous.dto.LoginDto;
import com.luminous.exception.DuplicateLoginIdException;
import com.luminous.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
public class MemberController {
	private final MemberService memberService;

    public MemberController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}

	@GetMapping("/join")
    public String joinForm(Model model) {
        model.addAttribute("member", new Member());
        return "join";
    }

    @PostMapping("/join")
    public String register(@ModelAttribute Member member, Model model) {
    	try {
            memberService.registerMember(member);
            return "redirect:/login";
        } catch (DuplicateLoginIdException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "join";
        } catch (Exception e) { // 모든 예외 잡기
            model.addAttribute("errorMessage", "회원가입 중 오류가 발생했습니다.");
            return "join";
        }
    }
    
	@GetMapping("/login")
    public String loginForm() {
        return "login";
    }
        
/*
    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("LoginDto", new LoginDto());
        return "login";
    }
    
	@PostMapping("/login")
	public String login(@ModelAttribute LoginDto loginDto, Model model) {
	    try {
	        Member member = memberService.login(loginDto);
	        // 세션에 로그인 정보 저장 등 추가 작업
	        return "redirect:/";
	    } catch (Exception e) {
	        model.addAttribute("errorMessage", "로그인 실패");
	        return "login";
	    }
	}
	*/
}

