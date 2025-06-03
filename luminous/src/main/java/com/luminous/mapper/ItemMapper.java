package com.luminous.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.luminous.domain.Image;
import com.luminous.domain.Item;

//ItemMapper.java (상품 기본 정보 전용)
@Mapper
public interface ItemMapper {
 void insertItem(Item item);
 void insertImage(Image image);
}


