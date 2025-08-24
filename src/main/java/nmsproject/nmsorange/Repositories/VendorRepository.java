package nmsproject.nmsorange.Repositories;



import nmsproject.nmsorange.Entities.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {

    Optional<Vendor> findByName(String name);

    List<Vendor> findByPortalTicketingSystem(String portalTicketingSystem);

    @Query("SELECT v FROM Vendor v WHERE v.mainContactEmail = :email OR v.escalationLevel1ContactEmail = :email OR v.escalationLevel2ContactEmail = :email")
    List<Vendor> findByEmail(@Param("email") String email);

    @Query("SELECT v FROM Vendor v WHERE v.name LIKE %:keyword% OR v.mainContactName LIKE %:keyword% OR v.mainContactEmail LIKE %:keyword%")
    List<Vendor> searchVendors(@Param("keyword") String keyword);

    boolean existsByName(String name);
}
