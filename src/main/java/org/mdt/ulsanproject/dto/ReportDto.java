package org.mdt.ulsanproject.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportDto {
    private String title;
    private String content;
    private int authorId;
    private String reportType;
    private String visibility;
    private String category;
    private LocalDate date;
    private String failureDefects;
}
