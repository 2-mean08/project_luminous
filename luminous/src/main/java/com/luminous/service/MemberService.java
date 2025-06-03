package com.luminous.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luminous.domain.Member;
import com.luminous.exception.DuplicateLoginIdException;
import com.luminous.mapper.MemberMapper;

@Service
public class MemberService {
    private final MemberMapper memberMapper;

    @Autowired
    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Transactional
    public void registerMember(Member member) {
        if (memberMapper.existsByLoginId(member.getLoginId())) {
            throw new DuplicateLoginIdException("이미 사용 중인 아이디입니다.");
        }
        memberMapper.insertMember(member);
    }
}
