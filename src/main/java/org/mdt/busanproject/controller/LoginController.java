package org.mdt.busanproject.controller;

import org.mdt.aioceaneye.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired private AdminService adminService;
    @Autowired private PilotService pilotService;
    @Autowired private CaptainService captainService;
    @Autowired private GuestService guestService;
    @Autowired private CompanyService companyService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> requestBody) {
        String email = requestBody.get("email");
        String password = requestBody.get("password");

        if (email == null || password == null) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Missing required parameters");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        String domain = getDomainFromEmail(email);
        String role = getRoleByDomain(domain);

        if (role == null) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Invalid domain for authentication");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        boolean isValidUser = false;
        Map<String, String> response = new HashMap<>();

        switch (role.toLowerCase()) {
            case "admin":
                isValidUser = adminService.validateUser(email, password);
                break;
            case "pilot":
                isValidUser = pilotService.validateUser(email, password);
                break;
            case "captain":
                isValidUser = captainService.validateUser(email, password);
                break;
            case "guest":
                isValidUser = guestService.validateUser(email, password);
                break;
            case "company":
                isValidUser = companyService.validateUser(email, password);
                break;
            default:
                response.put("message", "Invalid role");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        if (isValidUser) {
            response.put("message", "Login successful");
            response.put("role", role);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("message", "Invalid credentials");
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }
    }

    private String getDomainFromEmail(String email) {
        if (email != null && email.contains("@")) {
            return email.split("@")[1];
        }
        return null;
    }

    private String getRoleByDomain(String domain) {
        // Map domain to roles
        switch (domain.toLowerCase()) {
            case "admin.co.kr":
                return "admin";
            case "pilot.co.kr":
                return "pilot";
            case "vessel.co.kr":
                return "captain";
            case "guest.co.kr":
                return "guest";
            case "company.co.kr":
                return "company";
            default:
                return null; // Invalid domain
        }
    }
}
