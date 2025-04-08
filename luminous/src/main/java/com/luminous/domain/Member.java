package com.luminous.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long member_id;

    private String login_id;
    private String password;
    private String address;
    private String phone_number;
    private String email;
    private String nickname;
    private Timestamp timeRgst;
    private boolean admin;

    @OneToMany(mappedBy = "member")
    private List<Order> orders;

    @OneToMany(mappedBy = "member")
    private List<FAQ> faqs;
    
    @OneToMany(mappedBy = "member")
    private List<Image> images = new ArrayList<>();
}
