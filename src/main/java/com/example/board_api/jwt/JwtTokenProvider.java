//package com.example.board_api.jwt;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
////import lombok.Value;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.stereotype.Component;
//
//import javax.crypto.SecretKey;
//import java.security.Key;
//import java.util.Collection;
//import java.util.Date;
//import java.util.stream.Collectors;
//
//@Component
//public class JwtTokenProvider { //jwt 발급하고 검증하는 로직을 구현한 클래스
//    private final SecretKey key;//Secret key
//    private final long validityTime;//유효 시간
//
//    public JwtTokenProvider(
//            @Value("${jwt.secretKey}") String secretKey,
//            @Value("${jwt.accessTokenExpirationMs}") long validityTime) {
//        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
//        this.key = Keys.hmacShaKeyFor(keyBytes);
//        this.validityTime = validityTime;
//    }
//
//    public String createToken(String username, Collection<? extends GrantedAuthority> authorities) {
//        String authoritiesString = authorities.stream()
//                .map(GrantedAuthority::getAuthority)
//                .collect(Collectors.joining(","));
//
//        return Jwts.builder()
//                .setSubject(username)
//                .claim("auth", authoritiesString)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + validityTime))
//                .signWith(SignatureAlgorithm.HS256, key)
//                .compact();
//    }
//
//    public boolean validateToken(String token) {
//        try {
//            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public String getUsername(String token) {
//        return Jwts.parser().setSigningKey(secretKey)
//                .parseClaimsJws(token)
//                .getBody()
//                .getSubject();
//    }
//}
