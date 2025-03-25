package com.luminous.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "Company")
public class Company {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int company_id;

    private String company_intrd;
    private String company_history;
    private String location;
}