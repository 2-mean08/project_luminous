package com.luminous.domain;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no_id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member Member;

    private String no_title;
    private String no_content;
    private Timestamp no_date;

}
