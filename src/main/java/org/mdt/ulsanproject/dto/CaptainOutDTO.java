package org.mdt.ulsanproject.dto;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CaptainOutDTO extends CaptainBaseDTO {
    private int id;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private boolean isDelete;
}
