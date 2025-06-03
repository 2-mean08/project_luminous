package com.luminous.service;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.luminous.domain.CustomImage;
import com.luminous.dto.ImagePositionDTO;
import com.luminous.mapper.CustomImageMapper;

import lombok.RequiredArgsConstructor;

//CustomImageService.java
@Service
@RequiredArgsConstructor
public class CustomImageService {
 private final CustomImageMapper customImageMapper;
 private final FileStorageService fileStorageService;

 @Transactional
 public CustomImage addImage(MultipartFile file, ImagePositionDTO dto) throws IOException {
     String imageUrl = fileStorageService.upload(file);
     
     CustomImage image = new CustomImage();
     image.setImageUrl(imageUrl);
     image.setFileName(file.getOriginalFilename());
     image.setPosX(dto.getPosX());
     image.setPosY(dto.getPosY());
     image.setWidth(dto.getWidth());
     image.setHeight(dto.getHeight());
     
     BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
     image.setOriginalWidth((double)bufferedImage.getWidth());
     image.setOriginalHeight((double)bufferedImage.getHeight());
     
     customImageMapper.insertImage(image);
     return image;
 }

 @Transactional
 public void updateImagePosition(Long imageId, ImagePositionDTO dto) {
     CustomImage image = customImageMapper.getImageById(imageId);
     image.setPosX(dto.getPosX());
     image.setPosY(dto.getPosY());
     image.setWidth(dto.getWidth());
     image.setHeight(dto.getHeight());
     image.setRotation(dto.getRotation());
     
     customImageMapper.updateImage(image);
 }
}

