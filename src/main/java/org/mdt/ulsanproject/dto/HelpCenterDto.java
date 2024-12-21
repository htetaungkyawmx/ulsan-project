package org.mdt.ulsanproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HelpCenterDto {

    private String question;
    private String answer;
    private String category;
    private String tags;
    private String language;
    private Integer userRating;
    private Integer createdBy;
}
