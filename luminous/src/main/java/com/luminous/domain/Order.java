package com.luminous.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private String order_status;
    private BigDecimal total_price;
    private Timestamp order_date;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;
}
