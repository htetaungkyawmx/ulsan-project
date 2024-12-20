package org.mdt.ulsanproject.controller;

import org.mdt.ulsanproject.dto.UsersDto;
import org.mdt.ulsanproject.service.UsersService;
import org.mdt.ulsanproject.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    // Login endpoint
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsersDto usersDto) {
        try {
            // Authenticate user
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(usersDto.getUsername(), usersDto.getPassword())
            );

            // Load user details
            UserDetails userDetails = userDetailsService.loadUserByUsername(usersDto.getUsername());

            // Generate access and refresh tokens
            String accessToken = jwtUtil.generateAccessToken(userDetails.getUsername());
            String refreshToken = jwtUtil.generateRefreshToken(userDetails.getUsername());

            // Create response map
            Map<String, String> tokens = new HashMap<>();
            tokens.put("accessToken", accessToken);
            tokens.put("refreshToken", refreshToken);

            return ResponseEntity.ok(tokens);  // Return tokens as response

        } catch (Exception e) {
            // Handle authentication failure
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

    // Refresh token endpoint
    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(@RequestParam String refreshToken) {
        try {
            // Validate the refresh token
            if (jwtUtil.validateToken(refreshToken)) {
                String username = jwtUtil.extractUsername(refreshToken);  // Extract username from token
                String newAccessToken = jwtUtil.generateAccessToken(username);  // Generate new access token

                // Create response map with the new access token
                Map<String, String> tokens = new HashMap<>();
                tokens.put("accessToken", newAccessToken);

                return ResponseEntity.ok(tokens);  // Return new access token as response
            } else {
                // Handle invalid or expired refresh token
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid or expired refresh token");
            }
        } catch (Exception e) {
            // Handle any errors during refresh token processing
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Error refreshing token");
        }
    }
}
