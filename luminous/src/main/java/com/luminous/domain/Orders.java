package com.luminous.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;


public class Orders {

    private Long orderId; //PK

    private Long memberId; //FK
    private Long itemId; //FK

    private String orderStatus;
    private BigDecimal totalPrice;
    private Timestamp orderDate;


}
