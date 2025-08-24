package nmsproject.nmsorange.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "backups")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Backup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long applicationId;
    private String name;
    private String backupMode;
    private String frequency;
    private LocalDateTime latestUpdate;
    private String location; // internal or external
    private String filePath;
    private String backupType;

//    public Long getId() { return id; }
//    public void setId(Long id) { this.id = id; }
//    public Long getApplicationId() { return applicationId; }
//    public void setApplicationId(Long applicationId) { this.applicationId = applicationId; }
//    public String getName() { return name; }
//    public void setName(String name) { this.name = name; }
//    public String getBackupMode() { return backupMode; }
//    public void setBackupMode(String backupMode) { this.backupMode = backupMode; }
//    public String getFrequency() { return frequency; }
//    public void setFrequency(String frequency) { this.frequency = frequency; }
//    public LocalDateTime getLatestUpdate() { return latestUpdate; }
//    public void setLatestUpdate(LocalDateTime latestUpdate) { this.latestUpdate = latestUpdate; }
//    public String getLocation() { return location; }
//    public void setLocation(String location) { this.location = location; }
//    public String getFilePath() { return filePath; }
//    public void setFilePath(String filePath) { this.filePath = filePath; }
//    public String getBackupType() { return backupType; }
//    public void setBackupType(String backupType) { this.backupType = backupType; }
}