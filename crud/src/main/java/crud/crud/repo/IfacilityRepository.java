package crud.crud.repo;

import crud.crud.domain.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IfacilityRepository  extends JpaRepository<Facility, Long> {
}

