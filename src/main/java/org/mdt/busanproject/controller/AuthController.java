package org.mdt.busanproject.controller;

import org.mdt.busanproject.provider.JwtTokenProvider;
import org.mdt.busanproject.service.CustomUserDetailsService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final CustomUserDetailsService userDetailsService;

    public AuthController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, CustomUserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        // Authenticate the user
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        // Extract domain from the email
        String domain = extractDomainFromEmail(loginRequest.getUsername());

        // Assign roles based on the domain
        List<String> roles = assignRolesBasedOnDomain(domain);

        // Create and return the JWT token
        return jwtTokenProvider.createToken(loginRequest.getUsername(), roles);
    }

    // Extract the domain from email address
    private String extractDomainFromEmail(String email) {
        return email.substring(email.indexOf('@') + 1, email.indexOf('.'));
    }

    // Assign roles based on the domain
    private List<String> assignRolesBasedOnDomain(String domain) {
        switch (domain) {
            case "admin":
                return List.of("ROLE_ADMIN");
            case "pilot":
                return List.of("ROLE_PILOT");
            case "guest":
                return List.of("ROLE_GUEST");
            case "vessel":
                return List.of("ROLE_VESSEL");
            case "company":
                return List.of("ROLE_COMPANY");
            default:
                return List.of("ROLE_USER");
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
}
