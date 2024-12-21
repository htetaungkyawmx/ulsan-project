//package org.mdt.ulsanproject.model;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//public class RolePermission {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "role_id", referencedColumnName = "id")
//    private Role role;
//
//    @ManyToOne
//    @JoinColumn(name = "permission_id", referencedColumnName = "id")
//    private Permission permission;
//}
