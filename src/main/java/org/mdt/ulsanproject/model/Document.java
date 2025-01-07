package org.mdt.ulsanproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mdt.ulsanproject.dto.DocumentStatus;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true, length = 255)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column
    private Integer authorId;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(length = 50, nullable = false)
    private DocumentStatus status = DocumentStatus.DRAFT;

    @Column(columnDefinition = "TEXT")
    private String summary;

    @Column(length = 255)
    private String tags; // Store tags as a comma-separated string

    @Column(length = 100)
    private String category;

    @Column(length = 50)
    private String documentType;

    @Column(nullable = false)
    private boolean visibility = true;

    @Column(nullable = false)
    private boolean isDeleted = false;

    @Column(nullable = false)
    private int viewsCount = 0;

    @Column(nullable = false)
    private int likesCount = 0;

    @Column(nullable = false)
    private int downloadsCount = 0;

    @Column(length = 255)
    private String filePath;

    @Column(length = 255)
    private String thumbnailPath;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
