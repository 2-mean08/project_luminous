package com.luminous.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luminous.domain.Member;
import com.luminous.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;

@Service
public class MemberService {
    private final MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
		super();
		this.memberMapper = memberMapper;
	}

	@Transactional
    public void join(Member member) {
        memberMapper.insertMember(member);
    }
}

