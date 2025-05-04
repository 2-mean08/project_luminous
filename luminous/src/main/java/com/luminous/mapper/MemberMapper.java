package com.luminous.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.luminous.domain.Member;

@Mapper
public interface MemberMapper {
    void insertMember(Member member);
}

