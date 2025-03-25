package com.luminous.domain;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "Notices")
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no_id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private String no_title;
    private String no_content;
    private Timestamp no_date;
}
