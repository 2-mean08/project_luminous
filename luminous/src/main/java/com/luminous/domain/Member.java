package com.luminous.domain;

import java.sql.Timestamp;


public class Member {

    private Long memberId; //PK

    private String loginId;
    private String password;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String nickname;
    private Timestamp timeRgst; //가입 시기
    private Gender gender; //(male, female)
    private boolean admin;
	public Long getMemberId() {
		return memberId;
	}
	public String getLoginId() {
		return loginId;
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
	public String getPhoneNumber() {
		return phoneNumber;
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
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
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
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
