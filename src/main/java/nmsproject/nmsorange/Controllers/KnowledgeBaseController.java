package nmsproject.nmsorange.Controllers;


import jakarta.validation.Valid;
import nmsproject.nmsorange.Services.KnowledgeBaseService;
import nmsproject.nmsorange.dto.KnowledgeBaseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/knowledge-base")
@CrossOrigin(origins = "*")
public class KnowledgeBaseController {

    @Autowired
    private KnowledgeBaseService knowledgeBaseService;

    // Create knowledge base entry
    @PostMapping
    public ResponseEntity<KnowledgeBaseDTO> createKnowledgeBase(@Valid @RequestBody KnowledgeBaseDTO knowledgeBaseDTO) {
        Optional<KnowledgeBaseDTO> createdKnowledgeBase = knowledgeBaseService.createKnowledgeBase(knowledgeBaseDTO);
        return createdKnowledgeBase.map(kb -> new ResponseEntity<>(kb, HttpStatus.CREATED))
                .orElse(ResponseEntity.badRequest().build());
    }

    // Get all knowledge base entries
    @GetMapping
    public ResponseEntity<List<KnowledgeBaseDTO>> getAllKnowledgeBase() {
        List<KnowledgeBaseDTO> knowledgeBases = knowledgeBaseService.getAllKnowledgeBase();
        return ResponseEntity.ok(knowledgeBases);
    }

    // Get knowledge base by ID
    @GetMapping("/{id}")
    public ResponseEntity<KnowledgeBaseDTO> getKnowledgeBaseById(@PathVariable Long id) {
        Optional<KnowledgeBaseDTO> knowledgeBase = knowledgeBaseService.getKnowledgeBaseById(id);
        return knowledgeBase.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get knowledge base by vendor ID
    @GetMapping("/vendor/{vendorId}")
    public ResponseEntity<List<KnowledgeBaseDTO>> getKnowledgeBaseByVendorId(@PathVariable Long vendorId) {
        List<KnowledgeBaseDTO> knowledgeBases = knowledgeBaseService.getKnowledgeBaseByVendorId(vendorId);
        return ResponseEntity.ok(knowledgeBases);
    }

    // Get knowledge base by application name
    @GetMapping("/application/{applicationName}")
    public ResponseEntity<List<KnowledgeBaseDTO>> getKnowledgeBaseByApplicationName(@PathVariable String applicationName) {
        List<KnowledgeBaseDTO> knowledgeBases = knowledgeBaseService.getKnowledgeBaseByApplicationName(applicationName);
        return ResponseEntity.ok(knowledgeBases);
    }

    // Get knowledge base by application version
    @GetMapping("/version/{applicationVersion}")
    public ResponseEntity<List<KnowledgeBaseDTO>> getKnowledgeBaseByApplicationVersion(@PathVariable String applicationVersion) {
        List<KnowledgeBaseDTO> knowledgeBases = knowledgeBaseService.getKnowledgeBaseByApplicationVersion(applicationVersion);
        return ResponseEntity.ok(knowledgeBases);
    }

    // Search knowledge base by keyword
    @GetMapping("/search")
    public ResponseEntity<List<KnowledgeBaseDTO>> searchKnowledgeBase(@RequestParam String keyword) {
        List<KnowledgeBaseDTO> knowledgeBases = knowledgeBaseService.searchKnowledgeBase(keyword);
        return ResponseEntity.ok(knowledgeBases);
    }

    // Get knowledge base by vendor and application
    @GetMapping("/vendor/{vendorId}/application/{applicationName}")
    public ResponseEntity<List<KnowledgeBaseDTO>> getKnowledgeBaseByVendorAndApplication(
            @PathVariable Long vendorId, @PathVariable String applicationName) {
        List<KnowledgeBaseDTO> knowledgeBases = knowledgeBaseService.getKnowledgeBaseByVendorAndApplication(vendorId, applicationName);
        return ResponseEntity.ok(knowledgeBases);
    }

    // Get knowledge base by reported user ID
    @GetMapping("/reported-by/{userId}")
    public ResponseEntity<List<KnowledgeBaseDTO>> getKnowledgeBaseByReportedUserId(@PathVariable Long userId) {
        List<KnowledgeBaseDTO> knowledgeBases = knowledgeBaseService.getKnowledgeBaseByReportedUserId(userId);
        return ResponseEntity.ok(knowledgeBases);
    }

    // Get knowledge base by application ID
    @GetMapping("/app/{applicationId}")
    public ResponseEntity<List<KnowledgeBaseDTO>> getKnowledgeBaseByApplicationId(@PathVariable Long applicationId) {
        List<KnowledgeBaseDTO> knowledgeBases = knowledgeBaseService.getKnowledgeBaseByApplicationId(applicationId);
        return ResponseEntity.ok(knowledgeBases);
    }

    // Update knowledge base
    @PutMapping("/{id}")
    public ResponseEntity<KnowledgeBaseDTO> updateKnowledgeBase(@PathVariable Long id, @Valid @RequestBody KnowledgeBaseDTO knowledgeBaseDTO) {
        Optional<KnowledgeBaseDTO> updatedKnowledgeBase = knowledgeBaseService.updateKnowledgeBase(id, knowledgeBaseDTO);
        return updatedKnowledgeBase.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete knowledge base
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKnowledgeBase(@PathVariable Long id) {
        boolean deleted = knowledgeBaseService.deleteKnowledgeBase(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}