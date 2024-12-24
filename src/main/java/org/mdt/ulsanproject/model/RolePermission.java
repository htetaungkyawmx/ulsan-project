////package org.mdt.ulsanproject.model;
////
////import jakarta.persistence.*;
////import lombok.AllArgsConstructor;
////import lombok.Builder;
////import lombok.Data;
////import lombok.NoArgsConstructor;
////
////@Entity
////@Data
////@AllArgsConstructor
////@NoArgsConstructor
////@Builder
////public class RolePermission {
////
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Long id;
////
////    @ManyToOne
////    @JoinColumn(name = "role_id", referencedColumnName = "id")
////    private Role role;
////
////    @ManyToOne
////    @JoinColumn(name = "permission_id", referencedColumnName = "id")
////    private Permission permission;
////}
//
//
//
//
//
//package org.mdt.ulsanproject;
//
//import org.mdt.ulsanproject.model.Permission;
//import org.mdt.ulsanproject.model.Role;
//import org.mdt.ulsanproject.model.Users;
//import org.mdt.ulsanproject.repository.PermissionRepository;
//import org.mdt.ulsanproject.repository.RoleRepository;
//import org.mdt.ulsanproject.repository.UsersRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.HashSet;
//
//@Service
//public class DataSeederService {
//
//    @Autowired
//    private RoleRepository roleRepository;
//
//    @Autowired
//    private PermissionRepository permissionRepository;
//
//    @Autowired
//    private UsersRepository userRepository;
//
//    @Transactional
//    public void seedDatabase() {
//        resetDatabase();
//
//        // Seed roles
//        Role adminRole = seedRole("admin", "Full access to all system features.");
//        Role pilotRole = seedRole("pilot", "Can manage drone flights.");
//        Role mechanicRole = seedRole("mechanic", "Can perform drone maintenance.");
//        Role captainRole = seedRole("captain", "Can manage vessel operations.");
//        Role companyRole = seedRole("company", "Can manage company-related data.");
//
//        // Seed permissions
//        Permission createCompany = seedPermission("create_company", "Allow user to create a company.");
//        Permission readCompany = seedPermission("read_company", "Allow user to view company information.");
//        Permission updateCompany = seedPermission("update_company", "Allow user to update company details.");
//        Permission deleteCompany = seedPermission("delete_company", "Allow user to delete a company.");
//
//        // Assign permissions to roles
//        assignPermissionsToRole(adminRole, new HashSet<>(List.of(createCompany, readCompany, updateCompany, deleteCompany)));
//        assignPermissionsToRole(pilotRole, new HashSet<>(List.of(createCompany, readCompany))); // Example, adjust permissions
//        assignPermissionsToRole(mechanicRole, new HashSet<>(List.of(readCompany))); // Example, adjust permissions
//
//        // Seed demo users
//        seedUser("Admin", "admin@marine-drone.co.kr", "password123", adminRole);
//        seedUser("Pilot", "pilot@marine-drone.co.kr", "password123", pilotRole);
//        seedUser("Mechanic", "mechanic@marine-drone.co.kr", "password123", mechanicRole);
//        seedUser("Captain", "captain@marine-drone.co.kr", "password123", captainRole);
//        seedUser("Company", "company@marine-drone.co.kr", "password123", companyRole);
//    }
//
//    private Role seedRole(String name, String description) {
//        Optional<Role> existingRole = roleRepository.findByName(name);
//        if (existingRole.isPresent()) {
//            return existingRole.get();
//        }
//        Role role = new Role();
//        role.setName(name);
//        role.setDescription(description);
//        return roleRepository.save(role);
//    }
//
//    private Permission seedPermission(String name, String description) {
//        Optional<Permission> existingPermission = permissionRepository.findByName(name);
//        if (existingPermission.isPresent()) {
//            return existingPermission.get();
//        }
//        Permission permission = new Permission();
//        permission.setName(name);
//        permission.setDescription(description);
//        return permissionRepository.save(permission);
//    }
//
//    private void assignPermissionsToRole(Role role, Set<Permission> permissions) {
//        role.setPermissions(permissions);
//        roleRepository.save(role);
//    }
//
//    private void seedUser(String username, String email, String password, Role role) {
//        Optional<Users> existingUser = userRepository.findByUsername(username);
//        if (existingUser.isPresent()) {
//            return; // Skip if user already exists
//        }
//        Users user = new Users();
//        user.setUsername(username);
//        user.setEmail(email);
//        user.setPassword(password); // In real applications, hash the password here
//        user.setRole(role);
//        userRepository.save(user);
//    }
//
//    private void resetDatabase() {
//        permissionRepository.deleteAll();
//        roleRepository.deleteAll();
//        userRepository.deleteAll();
//    }
//}
