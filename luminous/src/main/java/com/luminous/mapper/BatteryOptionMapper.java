package com.luminous.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.luminous.domain.Options.BatteryOption;

@Mapper
public interface BatteryOptionMapper {
    void insertBatteryOption(BatteryOption option);
}