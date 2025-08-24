package nmsproject.nmsorange.Services;

import nmsproject.nmsorange.Entities.Backup;
import nmsproject.nmsorange.Repositories.BackupRepository;
import nmsproject.nmsorange.dto.BackupDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BackupService {

    private final BackupRepository repo;

    public BackupService(BackupRepository repo) {
        this.repo = repo;
    }

    public List<BackupDTO> getAllBackups() {
        return repo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public Optional<BackupDTO> getBackupById(Long id) {
        return repo.findById(id).map(this::toDTO);
    }

    public BackupDTO createBackup(BackupDTO dto) {
        Backup backup = toEntity(dto);
        return toDTO(repo.save(backup));
    }

    public Optional<BackupDTO> updateBackup(Long id, BackupDTO dto) {
        return repo.findById(id).map(existing -> {
            existing.setApplicationId(dto.getApplicationId());
            existing.setName(dto.getName());
            existing.setBackupMode(dto.getBackupMode());
            existing.setFrequency(dto.getFrequency());
            existing.setLatestUpdate(dto.getLatestUpdate());
            existing.setLocation(dto.getLocation());
            existing.setFilePath(dto.getFilePath());
            existing.setBackupType(dto.getBackupType());
            return toDTO(repo.save(existing));
        });
    }

    public boolean deleteBackup(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    private BackupDTO toDTO(Backup backup) {
        return BackupDTO.builder()
                .id(backup.getId())
                .applicationId(backup.getApplicationId())
                .name(backup.getName())
                .backupMode(backup.getBackupMode())
                .frequency(backup.getFrequency())
                .latestUpdate(backup.getLatestUpdate())
                .location(backup.getLocation())
                .filePath(backup.getFilePath())
                .backupType(backup.getBackupType())
                .build();
    }

    private Backup toEntity(BackupDTO dto) {
        Backup backup = new Backup();
        backup.setId(dto.getId());
        backup.setApplicationId(dto.getApplicationId());
        backup.setName(dto.getName());
        backup.setBackupMode(dto.getBackupMode());
        backup.setFrequency(dto.getFrequency());
        backup.setLatestUpdate(dto.getLatestUpdate());
        backup.setLocation(dto.getLocation());
        backup.setFilePath(dto.getFilePath());
        backup.setBackupType(dto.getBackupType());
        return backup;
    }
}