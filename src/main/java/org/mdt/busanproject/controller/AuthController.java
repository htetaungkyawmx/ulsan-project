package org.mdt.busanproject.controller;

import org.mdt.busanproject.provider.JwtTokenProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            // Authenticate the user
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );

            // Extract role from the email domain
            String email = loginRequest.getUsername();
            String domain = email.split("@")[1]; // Get domain from email

            // Assign roles based on the domain
            List<String> roles = List.of(getRoleForDomain(domain));

            // Generate the JWT token
            String token = jwtTokenProvider.createToken(loginRequest.getUsername(), roles);

            // Return the token as a response
            return ResponseEntity.ok(new LoginResponse(token));

        } catch (Exception e) {
            // Return error response if authentication fails
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid username or password");
        }
    }

    private String getRoleForDomain(String domain) {
        switch (domain) {
            case "admin.co.kr":
                return "ROLE_ADMIN";
            case "pilot.co.kr":
                return "ROLE_PILOT";
            case "guest.co.kr":
                return "ROLE_GUEST";
            case "company.co.kr":
                return "ROLE_COMPANY";
            case "vessel.co.kr":
                return "ROLE_VESSEL";
            default:
                return "ROLE_USER"; // Default role
        }
    }

    public static class LoginRequest {
        private String username;
        private String password;

        // Getters and setters
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    public static class LoginResponse {
        private String token;

        public LoginResponse(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
