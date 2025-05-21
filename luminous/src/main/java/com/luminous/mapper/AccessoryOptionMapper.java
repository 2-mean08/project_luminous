package com.luminous.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.luminous.domain.Options.AccessoryOption;

@Mapper
public interface AccessoryOptionMapper {
    void insertAccessoryOption(AccessoryOption option);
}
