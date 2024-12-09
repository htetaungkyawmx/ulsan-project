package org.mdt.ulsanproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VesselDto {

    private int id;
    private String name;
    private String type;
    private String status;
    private String capacity;
    private String location;

}
