package nmsproject.nmsorange.Controllers;

import lombok.RequiredArgsConstructor;
import nmsproject.nmsorange.Services.DatabaseService;
import nmsproject.nmsorange.dto.DatabaseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/databases")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class DatabaseController {

    private final DatabaseService databaseService;

    @PostMapping
    public ResponseEntity<DatabaseDTO> create(@RequestBody DatabaseDTO dto) {
        DatabaseDTO created = databaseService.createDatabase(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<List<DatabaseDTO>> findAll() {
        return ResponseEntity.ok(databaseService.getAllDatabases());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatabaseDTO> findById(@PathVariable Long id) {
        return databaseService.getDatabaseById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<DatabaseDTO> findByName(@PathVariable String name) {
        return databaseService.getDatabaseByName(name)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/application/{applicationId}")
    public ResponseEntity<List<DatabaseDTO>> findByApplication(@PathVariable Long applicationId) {
        return ResponseEntity.ok(databaseService.getDatabasesByApplicationId(applicationId));
    }

    @GetMapping("/search")
    public ResponseEntity<List<DatabaseDTO>> search(@RequestParam String keyword) {
        return ResponseEntity.ok(databaseService.searchDatabases(keyword));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DatabaseDTO> update(@PathVariable Long id, @RequestBody DatabaseDTO dto) {
        return databaseService.updateDatabase(id, dto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = databaseService.deleteDatabase(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/exists/{name}")
    public ResponseEntity<Boolean> existsByName(@PathVariable String name) {
        return ResponseEntity.ok(databaseService.databaseExistsByName(name));
    }
}