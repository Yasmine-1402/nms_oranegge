package nmsproject.nmsorange.Repositories;


import nmsproject.nmsorange.Entities.Rack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RackRepository extends JpaRepository<Rack, Long> {
}
