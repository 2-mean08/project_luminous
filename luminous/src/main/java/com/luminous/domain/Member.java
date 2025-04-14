package com.luminous.domain;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long member_id;

    private String login_id;
    private String password;
    private String name;
    private String address;
    private String phone_number;
    private String email;
    private String nickname;
    private Timestamp timeRgst; //가입 시기
    private Enum gender; //(male, female)
    private boolean admin;
    
    
	public Long getMember_id() {
		return member_id;
	}
	public String getLogin_id() {
		return login_id;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public String getEmail() {
		return email;
	}
	public String getNickname() {
		return nickname;
	}
	public Timestamp getTimeRgst() {
		return timeRgst;
	}
	public Enum getGender() {
		return gender;
	}
	public boolean isAdmin() {
		return admin;
	}
    
}
