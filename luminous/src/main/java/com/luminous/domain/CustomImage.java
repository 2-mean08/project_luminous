package com.luminous.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class CustomImage {

	@Id @GeneratedValue
	private Long cus_image_id;
	private Long cus_imageURL;
	
	private Double posX; 
    private Double posY;
    private Double width;
    private Double height;
    private Double rotation;
}
