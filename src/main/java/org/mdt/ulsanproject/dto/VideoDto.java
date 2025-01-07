package org.mdt.ulsanproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoDto {

    private int id;
    private String title;
    private String description;
    private String status;
    private String created_at;
    private String url;
}
