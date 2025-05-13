package com.luminous.domain;

import java.math.BigDecimal;

public class Item {


    private Long itemId; //PK
    private Long categoryId; //FK
    private Long imageId; //FK

    private String itemName;
    private BigDecimal price;


}
