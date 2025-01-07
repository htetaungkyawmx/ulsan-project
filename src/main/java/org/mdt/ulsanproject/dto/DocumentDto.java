package org.mdt.ulsanproject.dto;

import lombok.Data;

import java.util.List;

@Data
public class DocumentDto {
    private String title;
    private String content;
    private Integer authorId;
    private String summary;
    private List<String> tags; // List for handling tags in the DTO
    private String category;
    private String documentType;
    private boolean visibility;
    private String filePath;
    private String thumbnailPath;
}
