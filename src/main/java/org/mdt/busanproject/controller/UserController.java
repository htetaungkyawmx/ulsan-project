package org.mdt.busanproject.controller;

import org.mdt.busanproject.entity.Role;
import org.mdt.busanproject.entity.User;
import org.mdt.busanproject.repository.RoleRepository;
import org.mdt.busanproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping("/create")
    public User createUser(@RequestParam String username, @RequestParam String password, @RequestParam Set<String> roleNames) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(new BCryptPasswordEncoder().encode(password)); // Encode the password

        // Fetch roles by name
        Set<Role> roles = roleRepository.findAll().stream()
                .filter(role -> roleNames.contains(role.getName()))
                .collect(Collectors.toSet());
        user.setRoles(roles);

        return userRepository.save(user);
    }

    @GetMapping("/{username}/roles")
    public Set<Role> getUserRoles(@PathVariable String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return user.getRoles();
    }
}
