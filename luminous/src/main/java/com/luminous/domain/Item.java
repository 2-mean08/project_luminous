package com.luminous.domain;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long item_id;

    private String item_name;
    private int stockQuantity;
    private BigDecimal price;
	
    
    public Long getItem_id() {
		return item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}


}
