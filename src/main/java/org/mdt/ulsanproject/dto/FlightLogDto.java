package org.mdt.ulsanproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightLogDto {

    private int id;
    private String flight_number;
    private String company_id;
    private String drone_id;
    private String pilot_name;
    private String flight_date;
    private String duration;
    private String status;

}
