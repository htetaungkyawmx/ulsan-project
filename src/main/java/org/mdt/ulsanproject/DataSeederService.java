package org.mdt.ulsanproject;

import org.mdt.ulsanproject.model.Permission;
import org.mdt.ulsanproject.model.Role;
import org.mdt.ulsanproject.model.Users;
import org.mdt.ulsanproject.repository.PermissionRepository;
import org.mdt.ulsanproject.repository.RoleRepository;
import org.mdt.ulsanproject.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class DataSeederService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private UsersRepository userRepository;

    @Transactional
    public void seedDatabase() {
        // Seed roles
        Role adminRole = roleRepository.findById(1).orElseGet(() -> {
            Role role = new Role();
            role.setName("admin");
            role.setDescription("Full access to all system features.");
            return roleRepository.save(role);
        });

        Role pilotRole = roleRepository.findById(2).orElseGet(() -> {
            Role role = new Role();
            role.setName("pilot");
            role.setDescription("Can manage drone flights.");
            return roleRepository.save(role);
        });

        // Seed permissions
        Permission createCompany = permissionRepository.findByName("create_company").orElseGet(() -> {
            Permission permission = new Permission();
            permission.setName("create_company");
            permission.setDescription("Allow user to create a company.");
            return permissionRepository.save(permission);
        });

        Permission readCompany = permissionRepository.findByName("read_company").orElseGet(() -> {
            Permission permission = new Permission();
            permission.setName("read_company");
            permission.setDescription("Allow user to view company information.");
            return permissionRepository.save(permission);
        });

        // Seed users
        Optional<Users> adminUserOptional = userRepository.findByUsername("Admin");
        if (adminUserOptional.isEmpty()) {
            Users adminUser = new Users();
            adminUser.setUsername("Admin");
            adminUser.setEmail("admin@marine-drone.com");
            adminUser.setPassword("password123"); // You should hash passwords in a real-world app
            adminUser.setRole(adminRole);
            userRepository.save(adminUser);
        }

        Optional<Users> pilotUserOptional = userRepository.findByUsername("Pilot");
        if (pilotUserOptional.isEmpty()) {
            Users pilotUser = new Users();
            pilotUser.setUsername("Pilot");
            pilotUser.setEmail("pilot@marine-drone.com");
            pilotUser.setPassword("password123");
            pilotUser.setRole(pilotRole);
            userRepository.save(pilotUser);
        }
    }
}
