package com.luminous.domain.Options;

import java.sql.Timestamp;

public class BatteryOption {
	
	private Long itemId; //FPK
	private Long batterySeq; //PK(seq)
	private Long imageId; //FK
	
	private String color;
    private String capacity;
    private int batteryQuantity; //수량
    private Timestamp batteryPurchaseTime; //구매시간
	public Long getItemId() {
		return itemId;
	}
	public Long getBatterySeq() {
		return batterySeq;
	}
	public Long getImageId() {
		return imageId;
	}
	public String getColor() {
		return color;
	}
	public String getCapacity() {
		return capacity;
	}
	public int getBatteryQuantity() {
		return batteryQuantity;
	}
	public Timestamp getBatteryPurchaseTime() {
		return batteryPurchaseTime;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public void setBatterySeq(Long batterySeq) {
		this.batterySeq = batterySeq;
	}
	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public void setBatteryQuantity(int batteryQuantity) {
		this.batteryQuantity = batteryQuantity;
	}
	public void setBatteryPurchaseTime(Timestamp batteryPurchaseTime) {
		this.batteryPurchaseTime = batteryPurchaseTime;
	}
	



}
