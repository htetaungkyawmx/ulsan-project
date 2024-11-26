package org.mdt.busanproject.service;

import org.mdt.busanproject.entity.Role;
import org.mdt.busanproject.entity.User;
import org.mdt.busanproject.repository.RoleRepository;
import org.mdt.busanproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public void registerUser(User user) {
        // Assign default role
        Set<Role> roles = new HashSet<>();
        Role defaultRole = roleRepository.findByName("USER");
        if (defaultRole == null) {
            defaultRole = new Role();
            defaultRole.setName("USER");
            roleRepository.save(defaultRole);
        }
        roles.add(defaultRole);
        user.setRoles(roles);

        // Save the user
        userRepository.save(user);
    }

    public Set<Role> getUserRoles(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        return user.getRoles();
    }
}
