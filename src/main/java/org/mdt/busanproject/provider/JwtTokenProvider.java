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

    private final Key secretKey = Keys.hmacShaKeyFor("4f0c4054821bd7fdc9bea628448024dee6191c791c88af310be411f43b75f1997079197450b91f9fdb759202ee9016b3c9b0d19b43fcc1ad31df78d918c2cece58f90476243c2550f24a8ae9c95cd4bb9f32d7910a23596ad39da48b219633ede6cf8ed4432a0be45da727ebb2266cd053364c5e69508d739047a59610a4827f15ca2778c9b8f54a0e1944d8c500ba1fc4f8f47ad7ddd58274bc0324a77df3e4d09e0dd5984fd60effff6b6505e2808919ad3d99721042d0bc4bff49273c8466a39a8ad1a7f7f8bc06083d6e09a7ff2c4843684a14f61b905fb906f5be4d5f5c602b4521d15ef56571d72469707d5c638498492340d7ed257633de1c4310d629".getBytes());
    private final long validityInMilliseconds = 3600000; // 1 hour

    public String createToken(String username, List<String> roles) {
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("roles", roles);

        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

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
