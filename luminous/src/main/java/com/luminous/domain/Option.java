package com.luminous.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "Options")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int option_id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private String option_name;
}
