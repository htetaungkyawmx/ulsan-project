package org.mdt.ulsanproject.dto;

import lombok.Data;

import java.util.List;

@Data
public class AssignPermissionsDto {
    private List<Integer> permissionIds;
}
