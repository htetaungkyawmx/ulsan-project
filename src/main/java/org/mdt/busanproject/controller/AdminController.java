package org.mdt.busanproject.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/dashboard")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getAdminDashboard() {
        return "Welcome Admin";
    }

    @GetMapping("/settings")
    @PreAuthorize("hasAuthority('SETTING_PERMISSION')")
    public String getAdminSettings() {
        return "Admin Settings";
    }
}
