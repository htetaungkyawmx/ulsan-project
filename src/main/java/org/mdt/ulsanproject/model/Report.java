package org.mdt.ulsanproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", unique = true, nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "author_id", nullable = false)
    private int authorId;

    @Column(name = "report_type")
    private String reportType;

    @Column(name = "visibility", nullable = false)
    private String visibility = "Public";

    @Column(name = "category")
    private String category;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "failure_defects")
    private String failureDefects;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted = false;

    // Optional relationship with User (if required)
    // @ManyToOne
    // @JoinColumn(name = "author_id", referencedColumnName = "id", insertable = false, updatable = false)
    // private User author;

    @PreUpdate
    public void setUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }
}
