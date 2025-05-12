package com.luminous.dto;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.luminous.domain.Member;

//Member 정보를 UserDetails로 변환하는 어댑터 클래스
public class MemberDetailsDto implements UserDetails {

	private final Member member;

	public MemberDetailsDto(Member member) {
		super();
		this.member = member;
	}

	// 권한 반환 (admin이면 ROLE_ADMIN, 아니면 ROLE_USER)
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (member.isAdmin()) {
			return Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}
		return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getPassword() {
		return member.getPassword();
	}

	// 로그인 ID를 username으로 사용
	@Override
	public String getUsername() {
		return member.getLoginId();
	}

	// 계정 만료 등은 항상 true로 처리 (필요시 로직 추가)
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	// Member 엔티티 접근이 필요할 때 사용
	public Member getMember() {
		return member;
	}
}
