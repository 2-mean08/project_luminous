package com.luminous.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
		//.csrf(csrf -> csrf.disable()) // 개발 단계에서 임시로 CSRF 비활성화
				.authorizeHttpRequests(authz -> authz
						.requestMatchers(HttpMethod.GET, "/join").permitAll()
						.requestMatchers(HttpMethod.POST, "/join").permitAll()
						.requestMatchers("/login", "/join", "/css/**", "/js/**", "/images/**").permitAll().anyRequest()
						.authenticated())
				.formLogin(form -> form
						.loginPage("/login")
					    .loginProcessingUrl("/doLogin") // 실제 로그인 처리 경로를 변경
					    .defaultSuccessUrl("/")
					    .permitAll());
		return http.build();
	}
}
