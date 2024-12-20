package org.mdt.ulsanproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;  // Unique identifier for the video

    private String title;  // Title of the video

    private String description;  // Description of the video

    private String status;  // Status of the video (e.g., active, inactive)

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String createdAt;  // Timestamp of when the video was created

    private String url;  // URL or path of the video

    // Optionally, you can set up a relationship here if you want to reference the User model
    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "user_id")
    // private User author;  // Assuming a relationship with the User model

    @Override
    public String toString() {
        return "Video{id=" + id + ", title='" + title + "', url='" + url + "'}";
    }
}
