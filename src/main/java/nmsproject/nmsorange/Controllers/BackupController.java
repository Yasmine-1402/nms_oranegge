package nmsproject.nmsorange.Controllers;


import nmsproject.nmsorange.Entities.Backup;
import nmsproject.nmsorange.Repositories.BackupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/backups")
public class BackupController {

    @Autowired
    private BackupRepository backupRepository;

    @GetMapping
    public List<Backup> getAllBackups() {
        return backupRepository.findAll();
    }

    @GetMapping("/{id}")
    public Backup getBackupById(@PathVariable Long id) {
        return backupRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Backup createBackup(@RequestBody Backup backup) {
        return backupRepository.save(backup);
    }

    @PutMapping("/{id}")
    public Backup updateBackup(@PathVariable Long id, @RequestBody Backup backupDetails) {
        Backup backup = backupRepository.findById(id).orElse(null);
        if (backup != null) {
            backup.setName(backupDetails.getName());
            backup.setBackupMode(backupDetails.getBackupMode());
            backup.setFrequency(backupDetails.getFrequency());
            backup.setLatestUpdate(backupDetails.getLatestUpdate());
            backup.setLocation(backupDetails.getLocation());
            backup.setFilePath(backupDetails.getFilePath());
            backup.setBackupType(backupDetails.getBackupType());
            return backupRepository.save(backup);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteBackup(@PathVariable Long id) {
        backupRepository.deleteById(id);
    }
}