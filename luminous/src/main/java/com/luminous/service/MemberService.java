// MemberService.java (비즈니스 로직 처리)
package com.luminous.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luminous.domain.Member;
import com.luminous.dto.LoginDto;
import com.luminous.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;

@Service
public class MemberService {

    private final MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
		super();
		this.memberMapper = memberMapper;
	}

	// 회원 가입 처리
    @Transactional
    public void registerMember(Member member) {
        if (memberMapper.existsByLoginId(member.getLoginId())) {
            throw new IllegalStateException("이미 존재하는 아이디입니다.");
        }
        memberMapper.insertMember(member);
    }

    // 로그인 유효성 검사
    public boolean validateLogin(LoginDto loginDto) {
        LoginDto storedCredential = memberMapper.login(
            loginDto.getLoginId(), 
            loginDto.getPassword()
        );
        return storedCredential != null;
    }

    // 아이디로 회원 정보 조회
    public Member findByLoginId(String loginId) {
        return memberMapper.findByLoginId(loginId);
    }
}
