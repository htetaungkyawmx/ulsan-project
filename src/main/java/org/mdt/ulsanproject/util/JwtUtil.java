package org.mdt.ulsanproject.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    // Inject the secret key from application.yml
    @Value("${jwt.secret.key}")
    private String jwtSecretKey;

    private final long accessTokenValidity = 1000 * 60 * 15; // 15 minutes
    private final long refreshTokenValidity = 1000 * 60 * 60 * 24; // 24 hours

    // Method to generate access token
    public String generateAccessToken(String username) {
        return generateToken(username, accessTokenValidity);
    }

    // Method to generate refresh token
    public String generateRefreshToken(String username) {
        return generateToken(username, refreshTokenValidity);
    }

    // Private method to generate a JWT token with specified validity
    private String generateToken(String username, long validity) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + validity))
                .signWith(SignatureAlgorithm.HS256, jwtSecretKey) // Use injected secret key for HS256
                .compact();
    }

    // Method to validate the token
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(jwtSecretKey).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Method to extract username from the token
    public String extractUsername(String token) {
        return Jwts.parserBuilder().setSigningKey(jwtSecretKey).build().parseClaimsJws(token).getBody().getSubject();
    }
}
