package com.luminous.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "PopularItems")
public class PopularItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pop_item_id;

    private int sales_count;

    @OneToOne
    @JoinColumn(name = "item_id")
    private Item item;
}
