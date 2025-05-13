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
	



}
