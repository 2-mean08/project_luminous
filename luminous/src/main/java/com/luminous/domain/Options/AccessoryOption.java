package com.luminous.domain.Options;

import java.sql.Timestamp;

public class AccessoryOption {
	
	private Long itemId; //FPK
	private Long accessorySeq; //PK(seq)
	
	private String color;
    private String size;
    private String model;
    private int accessoryQuantity; //수량
    private Timestamp accessoryPurchaseTime; //구매시간


}
