package com.luminous.domain;

import java.math.BigDecimal;

public class Item {


    private Long itemId; //PK
    private Long categoryId; //FK

    private String itemName;
    private int stockQuantity;
    private BigDecimal price;


}
