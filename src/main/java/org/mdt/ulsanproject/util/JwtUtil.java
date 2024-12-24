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

    private final long accessTokenValidity = 1000 * 60 * 15; // 15 minutes
    private final long refreshTokenValidity = 1000 * 60 * 60 * 24; // 24 hours

    // Generate Access Token
    public String generateAccessToken(String username) {
        return generateToken(username, accessTokenValidity);
    }

    // Generate Refresh Token
    public String generateRefreshToken(String username) {
        return generateToken(username, refreshTokenValidity);
    }

    // Helper method to generate token
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

    // Validate Token
    public boolean validateToken(String token) {
        try {
            Jws<Claims> claimsJws = Jwts.parserBuilder()
                    .setSigningKey(jwtSecretKey)
                    .build()
                    .parseClaimsJws(token);

            // Check if the token has expired
            Date expirationDate = claimsJws.getBody().getExpiration();
            return expirationDate.after(new Date()); // Returns true if the token is valid and not expired
        } catch (ExpiredJwtException e) {
            // Handle expired token scenario
            System.out.println("Token has expired: " + e.getMessage());
        } catch (JwtException | IllegalArgumentException e) {
            // Handle other JWT exceptions (e.g., malformed, unsupported)
            System.out.println("Invalid token: " + e.getMessage());
        }
        return false; // If any exception is thrown, token is invalid
    }

    // Extract username from token
    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(jwtSecretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
