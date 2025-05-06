package com.luminous.dto;

public class LoginDto {
    private String loginId;
    private String password;

    // 기본 생성자
    public LoginDto() {} //요청 파라미터를 받아 객체를 생성할 때 기본 생성자를 호출한 뒤 setter를 통해 값을 넣어줌

    // 모든 필드를 받는 생성자
    public LoginDto(String loginId, String password) {
        this.loginId = loginId;
        this.password = password;
    }

    // getter, setter
    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

