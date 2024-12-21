package org.mdt.ulsanproject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class RoleDto {
    @NotBlank(message = "Role name is required")
    private String name;

    private String description;

    @NotNull(message = "Permission IDs must not be null")
    private List<Integer> permissionIds;
}
