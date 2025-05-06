package com.luminous.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.luminous.domain.Member;
import com.luminous.dto.LoginDto;
import com.luminous.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
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
    public String join(@ModelAttribute Member member) {
        memberService.join(member);
        return "redirect:/";
    }
    
    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("LoginDto", new LoginDto());
        return "login";
    }
    
	@PostMapping("/login")
	public String login(@ModelAttribute LoginDto loginDto) {
	    // loginDto.getLoginId(), loginDto.getPassword()로 값 사용
	    // 로그인 처리 로직
	    return "redirect:/";
	}
}

