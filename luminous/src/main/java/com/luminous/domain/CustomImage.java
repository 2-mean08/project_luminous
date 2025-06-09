package com.luminous.domain;

public class CustomImage {
	
    private Long customImageId;
    
    private String imageUrl;  // Long → String 타입으로 수정 (실제 URL 저장)
    private String fileName;  // 파일 식별을 위한 필드 추가
    
    // 좌표 및 변환 정보
    private Double posX;      // X축 위치 (0~1 비율 값 권장)
    private Double posY;      // Y축 위치 
    private Double width;     // 현재 너비 
    private Double height;    // 현재 높이
    private Double rotation;  // 회전 각도(0~360)
    
    // 이미지 원본 정보 (추천 필드)
    private Double originalWidth;   // 원본 이미지 너비
    private Double originalHeight;  // 원본 이미지 높이
    private Double scaleX;          // X축 스케일 비율
    private Double scaleY;          // Y축 스케일 비율
	public Long getCustomImageId() {
		return customImageId;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public String getFileName() {
		return fileName;
	}
	public Double getPosX() {
		return posX;
	}
	public Double getPosY() {
		return posY;
	}
	public Double getWidth() {
		return width;
	}
	public Double getHeight() {
		return height;
	}
	public Double getRotation() {
		return rotation;
	}
	public Double getOriginalWidth() {
		return originalWidth;
	}
	public Double getOriginalHeight() {
		return originalHeight;
	}
	public Double getScaleX() {
		return scaleX;
	}
	public Double getScaleY() {
		return scaleY;
	}
	public void setCustomImageId(Long customImageId) {
		this.customImageId = customImageId;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public void setPosX(Double posX) {
		this.posX = posX;
	}
	public void setPosY(Double posY) {
		this.posY = posY;
	}
	public void setWidth(Double width) {
		this.width = width;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public void setRotation(Double rotation) {
		this.rotation = rotation;
	}
	public void setOriginalWidth(Double originalWidth) {
		this.originalWidth = originalWidth;
	}
	public void setOriginalHeight(Double originalHeight) {
		this.originalHeight = originalHeight;
	}
	public void setScaleX(Double scaleX) {
		this.scaleX = scaleX;
	}
	public void setScaleY(Double scaleY) {
		this.scaleY = scaleY;
	}
}
