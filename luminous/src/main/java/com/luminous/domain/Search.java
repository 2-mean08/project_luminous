package com.luminous.domain;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "Search")
public class Search {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int search_id;

    private String search_content;
    private int search_frequency;
    private Timestamp last_search_date;
}
