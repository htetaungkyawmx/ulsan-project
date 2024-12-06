package org.mdt.ulsanproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {
    private int id;
    private String name;
    private Set<String> permissions;

}
