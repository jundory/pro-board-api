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

@Configuration  //스프링의 구성 클래스임을 의미 <- 덕분에 스프링이 자동 인식 후 설정 적용
@EnableWebSecurity // 웹 보안 활성화 + 스프링 시큐리티 설정 클래스임을 의미
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
                .csrf(csrf -> csrf.disable())   //csrf 비활성화
                .cors(cors -> cors.disable())   //cors 비활성화
                .authorizeRequests(authorize -> authorize
                        .requestMatchers("/**").permitAll() // 요청 허용할 경로 명시(현재는 모든 경로)
//                        .anyRequest().authenticated() // 밑의 permitAll()과 반대로 인증할 경로 명시(인증된 사용자만 접근 허용)
        );

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);   //쿠키 허용 여부
        config.setAllowedOrigins(Arrays.asList("http://localhost:9000"));   //허용할 도메인
        config.setAllowedMethods(Arrays.asList("HEAD","POST","GET","DELETE"));  //허용할 HTTP 메서드
        config.setAllowedHeaders(Arrays.asList("*"));   //허용할 헤더
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);    // 모든 경로에 대해 CORS 설정을 적용.
        return source;
    }
}
