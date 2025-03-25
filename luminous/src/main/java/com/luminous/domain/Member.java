package com.luminous.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter @Setter
@Entity
@Table(name = "Members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int member_id;

    private String login_id;
    private String username;
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

}
