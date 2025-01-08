package org.mdt.ulsanproject.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhotoDto {
    @NotEmpty(message = "Title cannot be empty")
    private String title;
    private String description;
    private String url;
}
