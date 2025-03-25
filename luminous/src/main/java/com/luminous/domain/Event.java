package com.luminous.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "Events")
public class Event {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int event_id;
    private String event_name;
    private String event_status;

}