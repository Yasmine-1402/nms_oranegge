package nmsproject.nmsorange.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KnowledgeBaseDTO {

    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    private String applicationName;
    private String solutionsSteps;
    private String attachedDocs;
    private String applicationVersion;
    private String imageUrl;
    private String description;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @NotNull(message = "Vendor ID is required")
    private Long vendorId;

    private Long applicationId;
    private Long reportedByUserId;
}
