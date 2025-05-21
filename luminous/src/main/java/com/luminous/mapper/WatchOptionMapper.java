package com.luminous.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.luminous.domain.Options.WatchOption;

@Mapper
public interface WatchOptionMapper {
    void insertWatchOption(WatchOption option);
}
