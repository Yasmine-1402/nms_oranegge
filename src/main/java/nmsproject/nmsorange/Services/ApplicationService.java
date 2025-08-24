package nmsproject.nmsorange.Services;

import nmsproject.nmsorange.Entities.Application;
import nmsproject.nmsorange.Repositories.ApplicationRepository;
import nmsproject.nmsorange.dto.ApplicationDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApplicationService {

    private final ApplicationRepository repo;

    public ApplicationService(ApplicationRepository repo) {
        this.repo = repo;
    }

    // Get all
    public List<ApplicationDTO> getAllApplications() {
        return repo.findAll()
                   .stream()
                   .map(this::toDTO)
                   .collect(Collectors.toList());
    }

    // Get by id
    public Optional<ApplicationDTO> getApplicationById(Long id) {
        return repo.findById(id).map(this::toDTO);
    }

    // Get by name
    public Optional<ApplicationDTO> getApplicationByName(String name) {
        return repo.findByName(name).map(this::toDTO);
    }

    // Create
    public ApplicationDTO createApplication(ApplicationDTO dto) {
        Application app = toEntity(dto);
        return toDTO(repo.save(app));
    }

    // Update
    public Optional<ApplicationDTO> updateApplication(Long id, ApplicationDTO dto) {
        return repo.findById(id).map(existing -> {
            existing.setName(dto.getName());
            existing.setDescription(dto.getDescription());
            existing.setAddedByUserId(dto.getAddedByUserId());
            existing.setVendorId(dto.getVendorId());
            return toDTO(repo.save(existing));
        });
    }

    // Delete
    public boolean deleteApplication(Long id) {
        if (!repo.existsById(id)) return false;
        repo.deleteById(id);
        return true;
    }

    // Converters
    private ApplicationDTO toDTO(Application app) {
        ApplicationDTO dto = new ApplicationDTO();
        dto.setId(app.getId());
        dto.setName(app.getName());
        dto.setDescription(app.getDescription());
        dto.setAddedByUserId(app.getAddedByUserId());
        dto.setVendorId(app.getVendorId());
        return dto;
    }

    private Application toEntity(ApplicationDTO dto) {
        Application app = new Application();
        app.setId(dto.getId());
        app.setName(dto.getName());
        app.setDescription(dto.getDescription());
        app.setAddedByUserId(dto.getAddedByUserId());
        app.setVendorId(dto.getVendorId());
        return app;
    }
}