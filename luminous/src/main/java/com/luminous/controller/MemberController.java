package com.luminous.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luminous.domain.Member;
import com.luminous.exception.DuplicateLoginIdException;
import com.luminous.service.MemberService;

@RestController
@RequestMapping("/api")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/join")
    public ResponseEntity<?> register(@RequestBody Member member) {
        try {
            memberService.registerMember(member);
            return ResponseEntity.ok().build();
        } catch (DuplicateLoginIdException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("회원가입 중 오류가 발생했습니다.");
        }
    }
}


