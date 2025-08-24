package nmsproject.nmsorange.Repositories;


import nmsproject.nmsorange.Entities.KnowledgeBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KnowledgeBaseRepository extends JpaRepository<KnowledgeBase, Long> {

    List<KnowledgeBase> findByVendorId(Long vendorId);

    List<KnowledgeBase> findByApplicationName(String applicationName);

    List<KnowledgeBase> findByApplicationVersion(String applicationVersion);

    @Query("SELECT kb FROM KnowledgeBase kb WHERE kb.title LIKE %:keyword% OR kb.solutionsSteps LIKE %:keyword% OR kb.applicationName LIKE %:keyword%")
    List<KnowledgeBase> searchKnowledgeBase(@Param("keyword") String keyword);

    @Query("SELECT kb FROM KnowledgeBase kb WHERE kb.vendor.id = :vendorId AND kb.applicationName = :applicationName")
    List<KnowledgeBase> findByVendorAndApplication(@Param("vendorId") Long vendorId, @Param("applicationName") String applicationName);

    List<KnowledgeBase> findByReportedByUserId(Long userId);

    List<KnowledgeBase> findByApplicationId(Long applicationId);
}
