package com.luminous.domain;


public class Image {

    private Long imageId; //PK
    private String imageURL; // 이미지 접근 URL 또는 경로
    private String imageName; // 파일명 (예: abc123.jpg)         
    private String fileType;  // MIME 타입 (image/jpeg, image/png 등)
    private Long fileSize;  // 파일 크기 (바이트 단위)

    
}

