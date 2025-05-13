package com.luminous.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.luminous.service.MemberDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	private final MemberDetailsService memberDetailsService;
	private final RoleBasedSuccessHandler roleBasedSuccessHandler;

	@Autowired
	public SecurityConfig(MemberDetailsService memberDetailsService, RoleBasedSuccessHandler roleBasedSuccessHandler) {
		super();
		this.memberDetailsService = memberDetailsService;
		this.roleBasedSuccessHandler = roleBasedSuccessHandler;
	}
	
	// 비밀번호 암호화용 빈 등록
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				// .csrf(csrf -> csrf.disable()) // 개발 단계에서 임시로 CSRF 비활성화
				// URL별 접근 권한 설정
				.authorizeHttpRequests(authz -> authz
						// 회원가입 페이지(GET, POST) 모두 비로그인 허용
						.requestMatchers(HttpMethod.GET, "/join").permitAll()
						.requestMatchers(HttpMethod.POST, "/join").permitAll()
						.requestMatchers("/login", "/join", "/css/**", "/js/**", "/images/**").permitAll() // 이외 모든 요청은 인증 필요
						.requestMatchers("/item/register").hasRole("ADMIN") // ✅ ADMIN만 접근 허용
						.anyRequest().authenticated())
				.formLogin(form -> form.loginPage("/login") // 커스텀 로그인 페이지
						.loginProcessingUrl("/login") // 로그인 처리 URL
						.usernameParameter("loginId") // 로그인 폼의 name 속성
						.passwordParameter("password").defaultSuccessUrl("/", true) // 로그인 성공 시 이동
						.failureUrl("/login?error=true") // 실패 시 이동
						.successHandler(roleBasedSuccessHandler) // 커스텀 핸들러 사용
						.permitAll())
				.logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/").permitAll());
		return http.build();
	}
}
