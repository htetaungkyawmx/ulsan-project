package org.mdt.ulsanproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VesselDto {

    private int id;
    private String serialnumber;
    private String name;
    private String type;
    private String manufacturer;
    private String picture;
    private float weight;
    private float capacity;
    private String IMO;
    private String MMSI;
    private String callsign;
    private String nation;
    private float length;
}
