package com.luminous.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luminous.domain.Member;
import com.luminous.dto.LoginDto;
import com.luminous.service.MemberService;

@RestController
@RequestMapping("/api")
public class MemberController {
	private final MemberService memberService;

	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@PostMapping("/join")
	public ResponseEntity<?> registerMember(@RequestBody Member member) {
		try {
			System.out.println("login_id: " + member.getLoginId());
			memberService.registerMember(member);
			return ResponseEntity.ok("회원 가입 성공");
		} catch (IllegalStateException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
		boolean isValid = memberService.validateLogin(loginDto);
		if (isValid) {
			return ResponseEntity.ok("로그인 성공");
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패");
	}

	@GetMapping("/checkId")
    public ResponseEntity<Map<String, Object>> checkIdDuplicate(@RequestParam("login_id") String loginId) {
        Map<String, Object> response = memberService.checkIdDuplicate(loginId);
        // 서비스에서 반환한 status 코드에 따라 응답
        int status = (int) response.getOrDefault("status", 200);

        if (status == 400) {
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok(response);
    }
}
