package org.mdt.ulsanproject.util;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    @Value("${jwt.secret.key}")
    private String jwtSecretKey;

    private final long accessTokenValidity = 1000 * 60 * 15;
    private final long refreshTokenValidity = 1000 * 60 * 60 * 24;

    public String generateAccessToken(String username) {
        return generateToken(username, accessTokenValidity);
    }

    public String generateRefreshToken(String username) {
        return generateToken(username, refreshTokenValidity);
    }

    private String generateToken(String username, long validity) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + validity))
                .signWith(SignatureAlgorithm.HS256, jwtSecretKey)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jws<Claims> claimsJws = Jwts.parserBuilder()
                    .setSigningKey(jwtSecretKey)
                    .build()
                    .parseClaimsJws(token);
            Date expirationDate = claimsJws.getBody().getExpiration();
            return expirationDate.after(new Date());
        } catch (ExpiredJwtException e) {
            System.out.println("Token has expired: " + e.getMessage());
        } catch (JwtException | IllegalArgumentException e) {
            System.out.println("Invalid token: " + e.getMessage());
        }
        return false;
    }

    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(jwtSecretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
