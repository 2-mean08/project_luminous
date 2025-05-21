package com.luminous.domain;

import java.math.BigDecimal;

public class Item {


    private Long itemId; //PK
    private Long categoryId; //FK
    private Long imageId; //FK

    private String itemName;
    private BigDecimal price;
    
    
	public Long getItemId() {
		return itemId;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public Long getImageId() {
		return imageId;
	}
	public String getItemName() {
		return itemName;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Long getParentCategoryId() {
		// TODO Auto-generated method stub
		return null;
	}


}
