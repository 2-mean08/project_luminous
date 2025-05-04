package com.luminous.domain.Options;

import java.sql.Timestamp;

public class WatchOption {
	
	private Long itemId; //FPK
	private Long watchSeq; //PK(seq)
	
	private String color;
    private String size;
    private String model;
    private int watchQuantity; //수량
    private Timestamp watchPurchaseTime; 

}
