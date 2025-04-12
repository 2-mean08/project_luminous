package com.luminous.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class PopularItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pop_item_id;

    private Long sales_count;

    @OneToOne
    @JoinColumn(name = "item_id")
    private Item item;

}
