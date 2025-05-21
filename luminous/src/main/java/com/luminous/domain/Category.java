package com.luminous.domain;

public class Category {


	private Long categoryId; //PK
    private Long parentCategoryId; //FK
    private String categoryName;
    private String description;
    
    public Long getCategoryId() {
		return categoryId;
	}
	public Long getParentCategoryId() {
		return parentCategoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public String getDescription() {
		return description;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public void setParentCategoryId(Long parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
