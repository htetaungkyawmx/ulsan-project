package org.mdt.ulsanproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceDto {

    private int id;
    private String drone_id;
    private String description;
    private String date;
    private String cost;

}
