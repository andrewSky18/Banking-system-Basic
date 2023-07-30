package crud.crud.repo;


import crud.crud.domain.LoanRequestTracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IloanRequestTrackerRepository extends JpaRepository<LoanRequestTracker, Long>{
}
