package com.luminous.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "Wishlist")
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int wishlist_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Member user;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private int option_id;
    private int order_id;
    private int wishlist_count;
    private boolean wishlist_select;
}
