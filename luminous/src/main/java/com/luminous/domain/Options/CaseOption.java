package com.luminous.domain.Options;

import java.sql.Timestamp;

public class CaseOption {
	
	private Long itemId; //FPK
	private Long caseSeq; //PK(seq)
	private Long imageId; //FK
	
	private String color;
    private String size;
    private String model;
    private int caseQuantity; //수량
    private Timestamp casePurchaseTime; //구매시간
	public Long getItemId() {
		return itemId;
	}
	public Long getCaseSeq() {
		return caseSeq;
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
	public int getCaseQuantity() {
		return caseQuantity;
	}
	public Timestamp getCasePurchaseTime() {
		return casePurchaseTime;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public void setCaseSeq(Long caseSeq) {
		this.caseSeq = caseSeq;
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
	public void setCaseQuantity(int caseQuantity) {
		this.caseQuantity = caseQuantity;
	}
	public void setCasePurchaseTime(Timestamp casePurchaseTime) {
		this.casePurchaseTime = casePurchaseTime;
	}



}
