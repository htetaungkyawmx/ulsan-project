package org.mdt.ulsanproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    // Many-to-many relationship with Permission
    @ManyToMany
    @JoinTable(
            name = "role_permission",  // Name of the join table
            joinColumns = @JoinColumn(name = "role_id"),  // Foreign key column for Role
            inverseJoinColumns = @JoinColumn(name = "permission_id")  // Foreign key column for Permission
    )
    private Set<Permission> permissions = new HashSet<>();

    // Optional one-to-many relationship with User (if applicable)
    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private Set<Users> users = new HashSet<>();
}
