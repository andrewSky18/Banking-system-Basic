package crud.crud.repo;

import crud.crud.domain.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IloanRepository extends JpaRepository<Loan, Long> {

}
