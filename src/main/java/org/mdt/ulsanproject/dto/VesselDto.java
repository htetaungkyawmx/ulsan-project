package org.mdt.ulsanproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VesselDto {

    private int id;
    private String serialnumber;  // Unique serial number for the vessel
    private String name;  // Vessel name
    private String type;  // Vessel type (e.g., cargo, tanker)
    private String manufacturer;  // Manufacturer name
    private String picture;  // URL or file path to vessel image
    private float weight;  // Weight of the vessel in tons
    private float capacity;  // Cargo/passenger capacity in tons
    private String IMO;  // International Maritime Organization number
    private String MMSI;  // Maritime Mobile Service Identity number
    private String callsign;  // Callsign of the vessel
    private String nation;  // Nation of registration
    private float length;  // Length of the vessel in meters
}
