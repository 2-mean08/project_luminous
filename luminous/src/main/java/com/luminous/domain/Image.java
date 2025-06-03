package com.luminous.domain;


public class Image {

    private Long imageId; //PK
    private Long itemId;// FK
    private String imageUrl; // 이미지 접근 URL 또는 경로
    private String imageName; // 파일명 (예: abc123.jpg)         
    private String fileType;  // MIME 타입 (image/jpeg, image/png 등)
    private Long fileSize;  // 파일 크기 (바이트 단위)
    private Enum imageType;  // 이미지 타입 (MAIN, DETAIL)
	public Long getImageId() {
		return imageId;
	}
	public Long getItemId() {
		return itemId;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public String getImageName() {
		return imageName;
	}
	public String getFileType() {
		return fileType;
	}
	public Long getFileSize() {
		return fileSize;
	}
	public Enum getImageType() {
		return imageType;
	}
	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}
	public void setImageType(Enum imageType) {
		this.imageType = imageType;
	}
    
    

    
    
}

