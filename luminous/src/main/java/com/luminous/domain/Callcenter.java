package com.luminous.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Callcenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long call_center_id;

    private String phone_number;
    private String operating_hours;

}
