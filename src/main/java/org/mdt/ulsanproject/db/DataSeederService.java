package org.mdt.ulsanproject.db;

import org.mdt.ulsanproject.model.Permission;
import org.mdt.ulsanproject.model.Role;
import org.mdt.ulsanproject.model.Users;
import org.mdt.ulsanproject.repository.PermissionRepository;
import org.mdt.ulsanproject.repository.RoleRepository;
import org.mdt.ulsanproject.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DataSeederService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;  // For password encryption

    @Transactional
    public void seedDatabase() {
        // Seed roles
        Role adminRole = createRoleIfNotExists("admin", "Full access to all system features.");
        Role pilotRole = createRoleIfNotExists("pilot", "Can manage drone flights.");
        Role mechanicRole = createRoleIfNotExists("mechanic", "Can perform drone maintenance.");
        Role captainRole = createRoleIfNotExists("captain", "Can manage vessel operations.");
        Role companyRole = createRoleIfNotExists("company", "Can manage company-related data.");

        // Seed permissions
        List<String> permissionNames = Arrays.asList(
                "create_company", "read_company", "update_company", "delete_company",
                "create_document", "read_document", "update_document", "delete_document",
                "create_drone", "read_drone", "update_drone", "delete_drone",
                "create_feedback", "read_feedback", "update_feedback", "delete_feedback",
                "create_flight_log", "read_flight_log", "update_flight_log", "delete_flight_log",
                "create_help_center", "read_help_center", "update_help_center", "delete_help_center",
                "create_maintenance", "read_maintenance", "update_maintenance", "delete_maintenance",
                "create_permission", "read_permission", "update_permission", "delete_permission",
                "create_photo", "read_photo", "update_photo", "delete_photo",
                "create_report", "read_report", "update_report", "delete_report",
                "create_role", "read_role", "update_role", "delete_role",
                "create_user", "read_user", "update_user", "delete_user",
                "create_vessel", "read_vessel", "update_vessel", "delete_vessel",
                "create_video", "read_video", "update_video", "delete_video"
        );

        permissionNames.forEach(this::createPermissionIfNotExists);

        // Seed users
        createUserIfNotExists("Admin", "admin@marine-drone.co.kr", adminRole);
        createUserIfNotExists("Pilot", "pilot@marine-drone.co.kr", pilotRole);
        createUserIfNotExists("Mechanic", "mechanic@marine-drone.co.kr", mechanicRole);
        createUserIfNotExists("Captain", "captain@marine-drone.co.kr", captainRole);
        createUserIfNotExists("Company", "company@marine-drone.co.kr", companyRole);

        // Optionally, associate role permissions (e.g., for admin role)
        associatePermissionsToRole(adminRole);
        associatePermissionsToRole(pilotRole);
        associatePermissionsToRole(mechanicRole);
        associatePermissionsToRole(captainRole);
        associatePermissionsToRole(companyRole);
    }

    private Role createRoleIfNotExists(String name, String description) {
        return roleRepository.findByName(name).orElseGet(() -> {
            Role role = new Role();
            role.setName(name);
            role.setDescription(description);
            return roleRepository.save(role);
        });
    }

    private void createPermissionIfNotExists(String permissionName) {
        permissionRepository.findByName(permissionName).orElseGet(() -> {
            Permission permission = new Permission();
            permission.setName(permissionName);
            permission.setDescription("Allow user to " + permissionName.replace("_", " ") + ".");
            return permissionRepository.save(permission);
        });
    }

    private void createUserIfNotExists(String username, String email, Role role) {
        usersRepository.findByUsername(username).orElseGet(() -> {
            Users user = new Users();
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(passwordEncoder.encode("password123")); // Password encryption
            user.setRole(role);
            return usersRepository.save(user);
        });
    }

    // This method associates permissions to the given role.
    private void associatePermissionsToRole(Role role) {
        List<Permission> permissions = permissionRepository.findAll();
        Set<Permission> permissionSet = new HashSet<>(permissions);  // Convert List to Set
        role.setPermissions(permissionSet);  // Many-to-many association
        roleRepository.save(role);  // Save the role with associated permissions
    }
}
