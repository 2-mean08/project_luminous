package com.luminous.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.luminous.domain.Options.CaseOption;

@Mapper
public interface CaseOptionMapper {
    void insertCaseOption(CaseOption option);
}
