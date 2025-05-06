package com.luminous.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luminous.domain.Member;
import com.luminous.dto.LoginDto;
import com.luminous.mapper.MemberMapper;

@Service
public class MemberService {
    public MemberService(MemberMapper memberMapper, PasswordEncoder passwordEncoder) {
		this.memberMapper = memberMapper;
		this.passwordEncoder = passwordEncoder;
	}

	private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;



	@Transactional //도중에 끊기면 DB에 전송 X
    public void join(Member member) {
		String plainPassword = member.getPassword();
		String hashedPassword = passwordEncoder.encode(plainPassword); //비밀번호 암호화
		member.setPassword(hashedPassword);
        memberMapper.insertMember(member);
    }
	
	 // 로그인 서비스 메서드 추가
	public Member login(LoginDto loginDto) { 
        // 1. ID로 회원 조회
        Member member = memberMapper.findByLoginId(loginDto.getLoginId());
        
        // 2. 회원 없거나 비밀번호 불일치 시 예외 발생
        if (member == null || !passwordEncoder.matches(loginDto.getPassword(), member.getPassword())) {
            throw new RuntimeException("로그인 실패");
        }
        
        return member;
    }
	

}

