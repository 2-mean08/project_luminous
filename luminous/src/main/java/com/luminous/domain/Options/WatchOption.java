package com.luminous.domain.Options;

import java.sql.Timestamp;

public class WatchOption {
	
	private Long itemId; //FPK
	private Long watchSeq; //PK(seq)
	private Long imageId; //FK
	
	private String color;
    private String size;
    private String model;
    private int watchQuantity; //수량
    private Timestamp watchPurchaseTime;
	public Long getItemId() {
		return itemId;
	}
	public Long getWatchSeq() {
		return watchSeq;
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
	public int getWatchQuantity() {
		return watchQuantity;
	}
	public Timestamp getWatchPurchaseTime() {
		return watchPurchaseTime;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public void setWatchSeq(Long watchSeq) {
		this.watchSeq = watchSeq;
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
	public void setWatchQuantity(int watchQuantity) {
		this.watchQuantity = watchQuantity;
	}
	public void setWatchPurchaseTime(Timestamp watchPurchaseTime) {
		this.watchPurchaseTime = watchPurchaseTime;
	} 

}
