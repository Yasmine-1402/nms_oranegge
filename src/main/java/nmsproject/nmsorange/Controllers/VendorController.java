package nmsproject.nmsorange.Controllers;


import jakarta.validation.Valid;
import nmsproject.nmsorange.Services.VendorService;
import nmsproject.nmsorange.dto.VendorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vendors")
@CrossOrigin(origins = "*")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    // Create vendor
    @PostMapping
    public ResponseEntity<VendorDTO> createVendor(@Valid @RequestBody VendorDTO vendorDTO) {
        VendorDTO createdVendor = vendorService.createVendor(vendorDTO);
        return new ResponseEntity<>(createdVendor, HttpStatus.CREATED);
    }

    // Get all vendors
    @GetMapping
    public ResponseEntity<List<VendorDTO>> getAllVendors() {
        List<VendorDTO> vendors = vendorService.getAllVendors();
        return ResponseEntity.ok(vendors);
    }

    // Get vendor by ID
    @GetMapping("/{id}")
    public ResponseEntity<VendorDTO> getVendorById(@PathVariable Long id) {
        Optional<VendorDTO> vendor = vendorService.getVendorById(id);
        return vendor.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get vendor by name
    @GetMapping("/name/{name}")
    public ResponseEntity<VendorDTO> getVendorByName(@PathVariable String name) {
        Optional<VendorDTO> vendor = vendorService.getVendorByName(name);
        return vendor.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Search vendors by keyword
    @GetMapping("/search")
    public ResponseEntity<List<VendorDTO>> searchVendors(@RequestParam String keyword) {
        List<VendorDTO> vendors = vendorService.searchVendors(keyword);
        return ResponseEntity.ok(vendors);
    }

    // Get vendors by portal ticketing system
    @GetMapping("/portal/{portalTicketingSystem}")
    public ResponseEntity<List<VendorDTO>> getVendorsByPortalTicketingSystem(@PathVariable String portalTicketingSystem) {
        List<VendorDTO> vendors = vendorService.getVendorsByPortalTicketingSystem(portalTicketingSystem);
        return ResponseEntity.ok(vendors);
    }

    // Get vendors by email
    @GetMapping("/email/{email}")
    public ResponseEntity<List<VendorDTO>> getVendorsByEmail(@PathVariable String email) {
        List<VendorDTO> vendors = vendorService.getVendorsByEmail(email);
        return ResponseEntity.ok(vendors);
    }

    // Update vendor
    @PutMapping("/{id}")
    public ResponseEntity<VendorDTO> updateVendor(@PathVariable Long id, @Valid @RequestBody VendorDTO vendorDTO) {
        Optional<VendorDTO> updatedVendor = vendorService.updateVendor(id, vendorDTO);
        return updatedVendor.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete vendor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVendor(@PathVariable Long id) {
        boolean deleted = vendorService.deleteVendor(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Check if vendor exists by name
    @GetMapping("/exists/{name}")
    public ResponseEntity<Boolean> vendorExistsByName(@PathVariable String name) {
        boolean exists = vendorService.vendorExistsByName(name);
        return ResponseEntity.ok(exists);
    }
}
