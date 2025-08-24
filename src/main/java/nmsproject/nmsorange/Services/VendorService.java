package nmsproject.nmsorange.Services;


import jakarta.validation.Valid;
import nmsproject.nmsorange.Entities.Vendor;
import nmsproject.nmsorange.Repositories.VendorRepository;
import nmsproject.nmsorange.dto.VendorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    // Create
    public VendorDTO createVendor(nmsproject.nmsorange.dto.@Valid VendorDTO vendorDTO) {
        Vendor vendor = convertToEntity(vendorDTO);
        Vendor savedVendor = vendorRepository.save(vendor);
        return convertToDTO(savedVendor);
    }

    // Read - Get all vendors
    public List<VendorDTO> getAllVendors() {
        return vendorRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Read - Get vendor by ID
    public Optional<VendorDTO> getVendorById(Long id) {
        return vendorRepository.findById(id)
                .map(this::convertToDTO);
    }

    // Read - Get vendor by name
    public Optional<VendorDTO> getVendorByName(String name) {
        return vendorRepository.findByName(name)
                .map(this::convertToDTO);
    }

    // Read - Search vendors by keyword
    public List<VendorDTO> searchVendors(String keyword) {
        return vendorRepository.searchVendors(keyword)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Read - Get vendors by portal ticketing system
    public List<VendorDTO> getVendorsByPortalTicketingSystem(String portalTicketingSystem) {
        return vendorRepository.findByPortalTicketingSystem(portalTicketingSystem)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Read - Get vendors by email
    public List<VendorDTO> getVendorsByEmail(String email) {
        return vendorRepository.findByEmail(email)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Update
    public Optional<VendorDTO> updateVendor(Long id, VendorDTO vendorDTO) {
        if (vendorRepository.existsById(id)) {
            Vendor vendor = convertToEntity(vendorDTO);
            vendor.setId(id);
            Vendor updatedVendor = vendorRepository.save(vendor);
            return Optional.of(convertToDTO(updatedVendor));
        }
        return Optional.empty();
    }

    // Delete
    public boolean deleteVendor(Long id) {
        if (vendorRepository.existsById(id)) {
            vendorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Check if vendor exists by name
    public boolean vendorExistsByName(String name) {
        return vendorRepository.existsByName(name);
    }

    // Helper methods for conversion
    private Vendor convertToEntity(VendorDTO vendorDTO) {
        Vendor vendor = new Vendor();
        vendor.setId(vendorDTO.getId());
        vendor.setName(vendorDTO.getName());
        vendor.setPortalTicketingSystem(vendorDTO.getPortalTicketingSystem());
        vendor.setPortalUsername(vendorDTO.getPortalUsername());
        vendor.setPortalPassword(vendorDTO.getPortalPassword());
        vendor.setMainContactName(vendorDTO.getMainContactName());
        vendor.setMainContactEmail(vendorDTO.getMainContactEmail());
        vendor.setMainContactMobile(vendorDTO.getMainContactMobile());
        vendor.setEscalationLevel1ContactName(vendorDTO.getEscalationLevel1ContactName());
        vendor.setEscalationLevel1ContactEmail(vendorDTO.getEscalationLevel1ContactEmail());
        vendor.setEscalationLevel1ContactMobile(vendorDTO.getEscalationLevel1ContactMobile());
        vendor.setEscalationLevel2ContactName(vendorDTO.getEscalationLevel2ContactName());
        vendor.setEscalationLevel2ContactEmail(vendorDTO.getEscalationLevel2ContactEmail());
        vendor.setEscalationLevel2ContactMobile(vendorDTO.getEscalationLevel2ContactMobile());
        return vendor;
    }

    private VendorDTO convertToDTO(Vendor vendor) {
        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setId(vendor.getId());
        vendorDTO.setName(vendor.getName());
        vendorDTO.setPortalTicketingSystem(vendor.getPortalTicketingSystem());
        vendorDTO.setPortalUsername(vendor.getPortalUsername());
        vendorDTO.setPortalPassword(vendor.getPortalPassword());
        vendorDTO.setMainContactName(vendor.getMainContactName());
        vendorDTO.setMainContactEmail(vendor.getMainContactEmail());
        vendorDTO.setMainContactMobile(vendor.getMainContactMobile());
        vendorDTO.setEscalationLevel1ContactName(vendor.getEscalationLevel1ContactName());
        vendorDTO.setEscalationLevel1ContactEmail(vendor.getEscalationLevel1ContactEmail());
        vendorDTO.setEscalationLevel1ContactMobile(vendor.getEscalationLevel1ContactMobile());
        vendorDTO.setEscalationLevel2ContactName(vendor.getEscalationLevel2ContactName());
        vendorDTO.setEscalationLevel2ContactEmail(vendor.getEscalationLevel2ContactEmail());
        vendorDTO.setEscalationLevel2ContactMobile(vendor.getEscalationLevel2ContactMobile());
        return vendorDTO;
    }
}
