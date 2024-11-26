package org.mdt.busanproject.provider;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.List;

@Component
public class JwtTokenProvider {

    private static final String SECRET_KEY = "your-256-bit-secret-your-256-bit-secret-your-secure-key";
    private final Key secretKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    private final long validityInMilliseconds = 3600000; // 1 hour validity

    /**
     * Generates a JWT token.
     * @param username The username of the user.
     * @param roles A list of roles assigned to the user.
     * @return A signed JWT token.
     */
    public String createToken(String username, List<String> roles) {
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("roles", roles); // Add roles to token claims

        Date now = new Date();
        Date expiry = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * Validates a JWT token.
     * @param token The JWT token to validate.
     * @return True if the token is valid, false otherwise.
     */
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false; // Token is invalid or expired
        }
    }

    /**
     * Extracts the username from the token.
     * @param token The JWT token.
     * @return The username embedded in the token.
     */
    public String getUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    /**
     * Extracts roles from the token.
     * @param token The JWT token.
     * @return A list of roles embedded in the token.
     */
    @SuppressWarnings("unchecked")
    public List<String> getRoles(String token) {
        return (List<String>) Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("roles", List.class);
    }
}
