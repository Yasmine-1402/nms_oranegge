package nmsproject.nmsorange.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "knowledge_base")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KnowledgeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "application_name")
    private String applicationName;

    @Column(name = "solutions_steps", columnDefinition = "TEXT")
    private String solutionsSteps;

    @Column(name = "attached_docs")
    private String attachedDocs;

    @Column(name = "application_version")
    private String applicationVersion;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Many-to-One relationship with Vendor
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendors_id")
    private Vendor vendor;

    // Foreign key references (these would typically link to other entities)
    @Column(name = "application_id")
    private Long applicationId;

    @Column(name = "reported_by_user_id")
    private Long reportedByUserId;

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

