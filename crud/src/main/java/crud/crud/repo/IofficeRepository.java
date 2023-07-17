package crud.crud.repo;

import crud.crud.domain.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IofficeRepository extends JpaRepository<Office, Long> {
}
