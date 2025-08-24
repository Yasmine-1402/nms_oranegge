package nmsproject.nmsorange.Repositories;

import nmsproject.nmsorange.Entities.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

    Optional<Application> findByName(String name);

    List<Application> findByVendorId(Long vendorId);

    List<Application> findByAddedByUserId(Long addedByUserId);

    @Query("SELECT a FROM Application a WHERE a.name LIKE %:keyword% OR a.description LIKE %:keyword%")
    List<Application> searchApplications(@Param("keyword") String keyword);

    boolean existsByName(String name);
}