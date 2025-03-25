package com.luminous.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "CallCenter")
public class CallCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int call_center_id;

    private String phone_number;
    private String operating_hours;
}
