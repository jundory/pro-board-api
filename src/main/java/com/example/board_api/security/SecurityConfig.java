package com.example.board_api.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity // 필터 체인 관리 시작 어노테이션
public class SecurityConfig {
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .httpBasic(HttpBasicConfigurer::disable)
//                .csrf(AbstractHttpConfigurer::disable)
//                .cors(AbstractHttpConfigurer::disable);
        http
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.disable())   //cors 설정 활성화
//                .authorizeRequests(auth -> auth
//                        .anyRequest().authenticated()
//                );
                .authorizeRequests(authorize -> authorize.requestMatchers("/**").permitAll() // 모든 요청 허용
        );

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration config = new CorsConfiguration();
        //쿠키 허용 여부
        config.setAllowCredentials(true);
        //허용할 도메인
        config.setAllowedOrigins(Arrays.asList("http://localhost:9000"));
        //허용할 HTTP 메서드
        config.setAllowedMethods(Arrays.asList("HEAD","POST","GET","DELETE"));
        //허용할 헤더
        config.setAllowedHeaders(Arrays.asList("*"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // 모든 경로에 대해 CORS 설정을 적용.
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
