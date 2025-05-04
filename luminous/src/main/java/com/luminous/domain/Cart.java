package com.luminous.domain;

public class Cart {

    private Long cartId; //PK
    private Long memberId; //FK
    private Long itemId; //FK

    private int optionId; //FK
    private int cartCount;
    private boolean cartSelect;

}
