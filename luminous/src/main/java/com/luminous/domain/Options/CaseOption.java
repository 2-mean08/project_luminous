package com.luminous.domain.Options;

import java.sql.Timestamp;

public class CaseOption {
	
	private Long itemId; //FPK
	private Long caseSeq; //PK(seq)
	
	private String color;
    private String size;
    private String model;
    private int caseQuantity; //수량
    private Timestamp casePurchaseTime; //구매시간



}
