// MemberService.java (비즈니스 로직 처리)
package com.luminous.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luminous.domain.Member;
import com.luminous.dto.LoginDto;
import com.luminous.mapper.MemberMapper;

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
    public Map<String, Object> checkIdDuplicate(String loginId) {
        Map<String, Object> response = new HashMap<>();

        // 1. 입력값 유효성 검사
        if (loginId == null || loginId.trim().isEmpty()) {
            response.put("exists", false);
            response.put("message", "아이디를 입력하세요.");
            response.put("status", 400); // 상태 코드 정보도 같이 반환 (선택)
            return response;
        }

        // 2. DB 중복 체크
        int count = memberMapper.countByLoginId(loginId);
        boolean exists = count > 0;
        response.put("exists", exists);
        response.put("message", exists ? "이미 사용중인 아이디입니다" : "사용 가능한 아이디입니다");
        response.put("status", 200);
        return response;
    }
}
