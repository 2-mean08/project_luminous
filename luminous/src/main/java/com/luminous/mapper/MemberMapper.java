package com.luminous.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.luminous.domain.Member;
import com.luminous.dto.LoginDto;

@Mapper
public interface MemberMapper {
    void insertMember(Member member);
    Member findByLoginId(String loginId);
    LoginDto login(@Param("loginId") String loginId, @Param("password") String password);
    boolean existsByLoginId(String loginId);
}


