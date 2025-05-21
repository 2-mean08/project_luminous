package com.luminous.domain.Options;

import java.sql.Timestamp;

public class AccessoryOption {
	
	private Long itemId; //FPK
	private Long accessorySeq; //PK(seq)
	private Long imageId; //FK
	
	private String color;
    private String size;
    private String model;
    private int accessoryQuantity; //수량
    private Timestamp accessoryPurchaseTime; //구매시간
	public Long getItemId() {
		return itemId;
	}
	public Long getAccessorySeq() {
		return accessorySeq;
	}
	public Long getImageId() {
		return imageId;
	}
	public String getColor() {
		return color;
	}
	public String getSize() {
		return size;
	}
	public String getModel() {
		return model;
	}
	public int getAccessoryQuantity() {
		return accessoryQuantity;
	}
	public Timestamp getAccessoryPurchaseTime() {
		return accessoryPurchaseTime;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public void setAccessorySeq(Long accessorySeq) {
		this.accessorySeq = accessorySeq;
	}
	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setAccessoryQuantity(int accessoryQuantity) {
		this.accessoryQuantity = accessoryQuantity;
	}
	public void setAccessoryPurchaseTime(Timestamp accessoryPurchaseTime) {
		this.accessoryPurchaseTime = accessoryPurchaseTime;
	}


}
