package org.mdt.ulsanproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedBackDto {

    private int id;
    private String rating;
    private String comment;
    private String created_at;
    private String user_id;

}
