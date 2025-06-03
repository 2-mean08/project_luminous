package com.luminous.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.luminous.domain.CustomImage;

//CustomImageMapper.java
@Mapper
public interface CustomImageMapper {
 @Insert("INSERT INTO custom_image(image_url, pos_x, pos_y, width, height, rotation, original_width, original_height) " +
         "VALUES(#{imageUrl}, #{posX}, #{posY}, #{width}, #{height}, #{rotation}, #{originalWidth}, #{originalHeight})")
 @Options(useGeneratedKeys = true, keyProperty = "customImageId")
 void insertImage(CustomImage image);

 @Update("UPDATE custom_image SET pos_x=#{posX}, pos_y=#{posY}, width=#{width}, height=#{height}, rotation=#{rotation} " +
         "WHERE custom_image_id=#{customImageId}")
 void updateImage(CustomImage image);

 @Select("SELECT * FROM custom_image WHERE custom_image_id=#{id}")
 CustomImage getImageById(Long id);
}

