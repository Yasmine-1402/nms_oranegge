package nmsproject.nmsorange.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nmsproject.nmsorange.Entities.Backup;

@Repository
public interface BackupRepository extends JpaRepository<Backup, Long> {


}

