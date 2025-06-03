package com.luminous.controller;
// CustomImageController.java


import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.luminous.domain.CustomImage;
import com.luminous.dto.ImagePositionDTO;
import com.luminous.service.CustomImageService;


@RestController
@RequestMapping("/api/images")
public class CustomImageController {
    private final CustomImageService imageService;

    public CustomImageController(CustomImageService imageService) {
		super();
		this.imageService = imageService;
	}

	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<CustomImage> uploadImage(
            @RequestPart("file") MultipartFile file,
            @RequestPart("data") ImagePositionDTO dto) throws IOException {
        return ResponseEntity.ok(imageService.addImage(file, dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateImage(
            @PathVariable Long id,
            @RequestBody ImagePositionDTO dto) {
        imageService.updateImagePosition(id, dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomImage> getImage(@PathVariable Long id) {
        return ResponseEntity.ok(imageService.getImageById(id));
    }
}
