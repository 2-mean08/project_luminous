package com.luminous.domain;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
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
    private Gender gender; //(male, female)
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
	public Gender getGender() {
		return gender;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setMember_id(Long member_id) {
		this.member_id = member_id;
	}
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public void setTimeRgst(Timestamp timeRgst) {
		this.timeRgst = timeRgst;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
    
    
}
