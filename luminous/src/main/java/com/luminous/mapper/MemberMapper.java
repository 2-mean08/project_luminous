package com.luminous.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.luminous.domain.Member;
import com.luminous.dto.LoginDto;

@Mapper
public interface MemberMapper {
    void insertMember(Member member); //회원 정보 등록
    Member findByLoginId(@Param("loginId") String loginId); // loginId로 회원 조회 (로그인용)
    LoginDto login(@Param("loginId") String loginId, @Param("password") String password);
    boolean existsByLoginId(String loginId);
    
}


