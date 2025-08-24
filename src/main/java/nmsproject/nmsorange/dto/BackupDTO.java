package nmsproject.nmsorange.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BackupDTO {
    private Long id;
    private Long applicationId;
    private String name;
    private String backupMode;
    private String frequency;
    private LocalDateTime latestUpdate;
    private String location;
    private String filePath;
    private String backupType;
}