package com.luminous.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.luminous.domain.Member;
import com.luminous.dto.MemberDetailsDto;
import com.luminous.mapper.MemberMapper;

@Service
public class MemberDetailsService implements UserDetailsService {

    private final MemberMapper memberMapper;

    @Autowired
    public MemberDetailsService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    // loginId로 회원을 조회하여 MemberDetails로 감싸 반환
    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        Member member = memberMapper.findByLoginId(loginId);
        if (member == null) {
            throw new UsernameNotFoundException("존재하지 않는 회원입니다.");
        }
        return new MemberDetailsDto(member);
    }
}
