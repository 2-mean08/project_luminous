package com.luminous.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfigurationSource;

import com.luminous.service.MemberDetailsService;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletResponse;

@EnableWebSecurity(debug = true)
public class SecurityConfig {
	private final MemberDetailsService memberDetailsService;
	private final CorsConfigurationSource corsConfigurationSource;

	@Autowired
	public SecurityConfig(MemberDetailsService memberDetailsService, CorsConfigurationSource corsConfigurationSource) {
		super();
		this.memberDetailsService = memberDetailsService;
		this.corsConfigurationSource = corsConfigurationSource;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http
	        .cors(cors -> cors.configurationSource(corsConfigurationSource))
	        .httpBasic(httpBasic -> httpBasic.disable())
	        .csrf(csrf -> csrf.disable())
	        .authorizeHttpRequests(authz -> authz
	            .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
	            .requestMatchers(HttpMethod.POST, "/api/join").permitAll()
	            .requestMatchers(HttpMethod.POST, "/api/login").permitAll()
	            .requestMatchers("/error", "/error/**").permitAll()
	            .requestMatchers("/api/admin/**").hasRole("ADMIN")
	            .anyRequest().authenticated()
	        )
	        .sessionManagement(session -> session
	            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	        )
	        .exceptionHandling(exceptions -> exceptions
	            .authenticationEntryPoint((request, response, authException) -> {
	            	if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
	                    response.setStatus(HttpServletResponse.SC_OK);
	                } else {
	                    response.setContentType("application/json;charset=UTF-8");
	                    response.setStatus(401);
	                    response.getWriter().write("{\"error\": \"Unauthorized\", \"message\": \"로그인이 필요합니다.\"}");
	                }
	            })
	            .accessDeniedHandler((request, response, accessDeniedException) -> {
	                response.setContentType("application/json");
	                response.setStatus(403);
	                response.getWriter().write("{\"error\": \"Forbidden\", \"message\": \"관리자만 접근 가능합니다.\"}");
	            })
	        )
	        .userDetailsService(memberDetailsService);

	    return http.build();
	}
	@PostConstruct
    public void init() {
        System.out.println(">>> SecurityConfig가 실제로 빈으로 등록되어 실행되었습니다.");
	}

}
