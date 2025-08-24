package nmsproject.nmsorange.Services;


import nmsproject.nmsorange.Entities.KnowledgeBase;
import nmsproject.nmsorange.Entities.Vendor;
import nmsproject.nmsorange.Repositories.KnowledgeBaseRepository;
import nmsproject.nmsorange.Repositories.VendorRepository;
import nmsproject.nmsorange.dto.KnowledgeBaseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class KnowledgeBaseService {

    @Autowired
    private KnowledgeBaseRepository knowledgeBaseRepository;

    @Autowired
    private VendorRepository vendorRepository;

    // Create
    public Optional<KnowledgeBaseDTO> createKnowledgeBase(KnowledgeBaseDTO knowledgeBaseDTO) {
        Optional<Vendor> vendor = vendorRepository.findById(knowledgeBaseDTO.getVendorId());
        if (vendor.isPresent()) {
            KnowledgeBase knowledgeBase = convertToEntity(knowledgeBaseDTO);
            knowledgeBase.setVendor(vendor.get());
            KnowledgeBase savedKnowledgeBase = knowledgeBaseRepository.save(knowledgeBase);
            return Optional.of(convertToDTO(savedKnowledgeBase));
        }
        return Optional.empty();
    }

    // Read - Get all knowledge base entries
    public List<KnowledgeBaseDTO> getAllKnowledgeBase() {
        return knowledgeBaseRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Read - Get knowledge base by ID
    public Optional<KnowledgeBaseDTO> getKnowledgeBaseById(Long id) {
        return knowledgeBaseRepository.findById(id)
                .map(this::convertToDTO);
    }

    // Read - Get knowledge base by vendor ID
    public List<KnowledgeBaseDTO> getKnowledgeBaseByVendorId(Long vendorId) {
        return knowledgeBaseRepository.findByVendorId(vendorId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Read - Get knowledge base by application name
    public List<KnowledgeBaseDTO> getKnowledgeBaseByApplicationName(String applicationName) {
        return knowledgeBaseRepository.findByApplicationName(applicationName)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Read - Get knowledge base by application version
    public List<KnowledgeBaseDTO> getKnowledgeBaseByApplicationVersion(String applicationVersion) {
        return knowledgeBaseRepository.findByApplicationVersion(applicationVersion)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Read - Search knowledge base by keyword
    public List<KnowledgeBaseDTO> searchKnowledgeBase(String keyword) {
        return knowledgeBaseRepository.searchKnowledgeBase(keyword)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Read - Get knowledge base by vendor and application
    public List<KnowledgeBaseDTO> getKnowledgeBaseByVendorAndApplication(Long vendorId, String applicationName) {
        return knowledgeBaseRepository.findByVendorAndApplication(vendorId, applicationName)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Read - Get knowledge base by reported user ID
    public List<KnowledgeBaseDTO> getKnowledgeBaseByReportedUserId(Long userId) {
        return knowledgeBaseRepository.findByReportedByUserId(userId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Read - Get knowledge base by application ID
    public List<KnowledgeBaseDTO> getKnowledgeBaseByApplicationId(Long applicationId) {
        return knowledgeBaseRepository.findByApplicationId(applicationId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Update
    public Optional<KnowledgeBaseDTO> updateKnowledgeBase(Long id, KnowledgeBaseDTO knowledgeBaseDTO) {
        if (knowledgeBaseRepository.existsById(id)) {
            Optional<Vendor> vendor = vendorRepository.findById(knowledgeBaseDTO.getVendorId());
            if (vendor.isPresent()) {
                KnowledgeBase knowledgeBase = convertToEntity(knowledgeBaseDTO);
                knowledgeBase.setId(id);
                knowledgeBase.setVendor(vendor.get());
                KnowledgeBase updatedKnowledgeBase = knowledgeBaseRepository.save(knowledgeBase);
                return Optional.of(convertToDTO(updatedKnowledgeBase));
            }
        }
        return Optional.empty();
    }

    // Delete
    public boolean deleteKnowledgeBase(Long id) {
        if (knowledgeBaseRepository.existsById(id)) {
            knowledgeBaseRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Helper methods for conversion
    private KnowledgeBase convertToEntity(KnowledgeBaseDTO knowledgeBaseDTO) {
        KnowledgeBase knowledgeBase = new KnowledgeBase();
        knowledgeBase.setId(knowledgeBaseDTO.getId());
        knowledgeBase.setTitle(knowledgeBaseDTO.getTitle());
        knowledgeBase.setApplicationName(knowledgeBaseDTO.getApplicationName());
        knowledgeBase.setSolutionsSteps(knowledgeBaseDTO.getSolutionsSteps());
        knowledgeBase.setAttachedDocs(knowledgeBaseDTO.getAttachedDocs());
        knowledgeBase.setApplicationVersion(knowledgeBaseDTO.getApplicationVersion());
        knowledgeBase.setImageUrl(knowledgeBaseDTO.getImageUrl());
        knowledgeBase.setDescription(knowledgeBaseDTO.getDescription());
        knowledgeBase.setApplicationId(knowledgeBaseDTO.getApplicationId());
        knowledgeBase.setReportedByUserId(knowledgeBaseDTO.getReportedByUserId());
        return knowledgeBase;
    }

    private KnowledgeBaseDTO convertToDTO(KnowledgeBase knowledgeBase) {
        KnowledgeBaseDTO knowledgeBaseDTO = new KnowledgeBaseDTO();
        knowledgeBaseDTO.setId(knowledgeBase.getId());
        knowledgeBaseDTO.setTitle(knowledgeBase.getTitle());
        knowledgeBaseDTO.setApplicationName(knowledgeBase.getApplicationName());
        knowledgeBaseDTO.setSolutionsSteps(knowledgeBase.getSolutionsSteps());
        knowledgeBaseDTO.setAttachedDocs(knowledgeBase.getAttachedDocs());
        knowledgeBaseDTO.setApplicationVersion(knowledgeBase.getApplicationVersion());
        knowledgeBaseDTO.setImageUrl(knowledgeBase.getImageUrl());
        knowledgeBaseDTO.setCreatedAt(knowledgeBase.getCreatedAt());
        knowledgeBaseDTO.setUpdatedAt(knowledgeBase.getUpdatedAt());
        knowledgeBaseDTO.setVendorId(knowledgeBase.getVendor().getId());
        knowledgeBaseDTO.setDescription(knowledgeBase.getDescription());
        knowledgeBaseDTO.setApplicationId(knowledgeBase.getApplicationId());
        knowledgeBaseDTO.setReportedByUserId(knowledgeBase.getReportedByUserId());
        return knowledgeBaseDTO;
    }
}
