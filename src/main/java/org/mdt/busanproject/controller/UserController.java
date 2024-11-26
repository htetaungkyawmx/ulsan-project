package org.mdt.busanproject.controller;

import org.mdt.busanproject.entity.Role;
import org.mdt.busanproject.entity.User;
import org.mdt.busanproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        userService.registerUser(user);
        return "User registered successfully";
    }

    @GetMapping("/{username}/roles")
    public Set<Role> getUserRoles(@PathVariable String username) {
        return userService.getUserRoles(username);
    }
}
