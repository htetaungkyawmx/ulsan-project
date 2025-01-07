package org.mdt.ulsanproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedBackDto {

    private int id;              // ID of the feedback
    private String content;      // Content of the feedback
    private int userId;          // User ID for the feedback
}
