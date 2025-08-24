package nmsproject.nmsorange.Services;

import lombok.RequiredArgsConstructor;
import nmsproject.nmsorange.Entities.Application;
import nmsproject.nmsorange.Entities.Database;
import nmsproject.nmsorange.Repositories.ApplicationRepository;
import nmsproject.nmsorange.Repositories.DatabaseRepository;
import nmsproject.nmsorange.dto.DatabaseDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DatabaseService {

    private final DatabaseRepository databaseRepository;
    private final ApplicationRepository applicationRepository;

    // CREATE
    public DatabaseDTO createDatabase(DatabaseDTO dto) {
        if (dto.getApplicationId() == null) {
            throw new IllegalArgumentException("applicationId is required");
        }
        Database entity = toEntity(dto);
        Database saved = databaseRepository.save(entity);
        return toDTO(saved);
    }

    // READ
    public List<DatabaseDTO> getAllDatabases() {
        return databaseRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public Optional<DatabaseDTO> getDatabaseById(Long id) {
        return databaseRepository.findById(id).map(this::toDTO);
    }

    public Optional<DatabaseDTO> getDatabaseByName(String name) {
        return databaseRepository.findByName(name).map(this::toDTO);
    }

    public List<DatabaseDTO> getDatabasesByApplicationId(Long applicationId) {
        return databaseRepository.findByApplicationId(applicationId)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<DatabaseDTO> searchDatabases(String keyword) {
        return databaseRepository.searchDatabases(keyword)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    // UPDATE
    public Optional<DatabaseDTO> updateDatabase(Long id, DatabaseDTO dto) {
        return databaseRepository.findById(id).map(existing -> {
            existing.setName(dto.getName());
            existing.setUrlAddress(dto.getUrlAddress());
            existing.setPort(dto.getPort());
            existing.setType(dto.getType());
            existing.setUsername(dto.getUsername());
            existing.setPassword(dto.getPassword());
            existing.setCurrentVersion(dto.getCurrentVersion());
            existing.setLastUpdate(dto.getLastUpdate());
            existing.setPlannedUpdate(dto.getPlannedUpdate());

            if (dto.getApplicationId() != null) {
                Application app = applicationRepository.findById(dto.getApplicationId())
                        .orElseThrow(() -> new IllegalArgumentException("Application not found with id " + dto.getApplicationId()));
                existing.setApplication(app);
            }
            return toDTO(databaseRepository.save(existing));
        });
    }

    // DELETE
    public boolean deleteDatabase(Long id) {
        if (databaseRepository.existsById(id)) {
            databaseRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean databaseExistsByName(String name) {
        return databaseRepository.existsByName(name);
    }

    // Mappers
    private DatabaseDTO toDTO(Database db) {
        return DatabaseDTO.builder()
                .id(db.getId())
                .name(db.getName())
                .urlAddress(db.getUrlAddress())
                .port(db.getPort())
                .type(db.getType())
                .username(db.getUsername())
                .password(db.getPassword())
                .currentVersion(db.getCurrentVersion())
                .lastUpdate(db.getLastUpdate())
                .plannedUpdate(db.getPlannedUpdate())
                .applicationId(db.getApplication() != null ? db.getApplication().getId() : null)
                .build();
    }

    private Database toEntity(DatabaseDTO dto) {
        Application app = applicationRepository.findById(dto.getApplicationId())
                .orElseThrow(() -> new IllegalArgumentException("Application not found with id " + dto.getApplicationId()));

        return Database.builder()
                .id(dto.getId())
                .name(dto.getName())
                .urlAddress(dto.getUrlAddress())
                .port(dto.getPort())
                .type(dto.getType())
                .username(dto.getUsername())
                .password(dto.getPassword())
                .currentVersion(dto.getCurrentVersion())
                .lastUpdate(dto.getLastUpdate())
                .plannedUpdate(dto.getPlannedUpdate())
                .application(app)
                .build();
    }
}