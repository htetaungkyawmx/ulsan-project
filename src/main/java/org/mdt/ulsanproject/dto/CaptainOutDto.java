package org.mdt.ulsanproject.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CaptainOutDto extends CaptainBaseDto {
    private int id;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private boolean isDelete;
}
