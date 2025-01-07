package org.mdt.ulsanproject.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "help_centers")
public class HelpCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "question", length = 255, nullable = false)
    private String question;

    @Column(name = "answer", columnDefinition = "TEXT", nullable = false)
    private String answer;

    @Column(name = "category", length = 100)
    private String category;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "status", length = 50, nullable = false)
    private String status = "active";

    @Column(name = "visibility", nullable = false)
    private Boolean visibility = true;  // Default value set to true

    @Column(name = "tags", length = 255)
    private String tags;

    @Column(name = "language", length = 10, nullable = false)
    private String language = "en";

    @Column(name = "user_rating")
    private Integer userRating;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(nullable = true) // Allow null values
    private Boolean isDeleted = false;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
