package org.adaschool.sistemareservasada.application.service;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

@Service
public record JwtService(
    @Value("${application.security.jwt.secret-key}")
    String secretKey,
    @Value("${application.security.jwt.expiration}")
    Long jwtExpiration
) {

    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(HashMap<String,Object> extracClaims, UserDetails userDetails){
        return buildToken(extracClaims, userDetails, jwtExpiration);
    }
    private String buildToken(HashMap<String, Object> extractClaims, UserDetails userDetails, Long expiration){
        return Jwts.builder()
                .setClaims(extractClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(Date.from(
                        LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()
                        ))
                .setExpiration(Date.from(
                        LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().plusMillis(expiration)
                ))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    public String extractUserName (String token){
        return extractClaim(token, Claims::getSubject);
    }
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }


    public boolean isTokenValid(String token, UserDetails userDetails){
        final String userName = extractUserName(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public boolean isTokenExpired(String token){
        return extractExpiration(token).isBefore(LocalDateTime.now());
    }

    private LocalDateTime extractExpiration(String token) {
        Date date = extractClaim(token,Claims::getExpiration);
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
