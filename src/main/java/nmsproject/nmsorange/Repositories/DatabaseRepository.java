package nmsproject.nmsorange.Repositories;

import nmsproject.nmsorange.Entities.Database;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DatabaseRepository extends JpaRepository<Database, Long> {

    Optional<Database> findByName(String name);

    List<Database> findByType(String type);

    List<Database> findByApplicationId(Long applicationId);

    @Query("SELECT d FROM Database d WHERE d.username = :username")
    List<Database> findByUsername(@Param("username") String username);

    @Query("""
           SELECT d FROM Database d
           WHERE LOWER(d.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
              OR LOWER(d.type) LIKE LOWER(CONCAT('%', :keyword, '%'))
              OR LOWER(d.username) LIKE LOWER(CONCAT('%', :keyword, '%'))
              OR LOWER(d.currentVersion) LIKE LOWER(CONCAT('%', :keyword, '%'))
           """)
    List<Database> searchDatabases(@Param("keyword") String keyword);

    boolean existsByName(String name);
}