package org.mdt.ulsanproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentDto {

    private int id;
    private String title;
    private String content;
    private Integer author_id;  // Ensure it's Integer to accommodate null values
    private String summary;
    private String tags;
    private String category;
    private String documentType;
    private boolean visibility;
    private String filePath;
    private String thumbnailPath;
}
