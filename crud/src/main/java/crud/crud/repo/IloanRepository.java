package crud.crud.repo;

import crud.crud.domain.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IloanRepository extends JpaRepository<Loan, Long> {

    @Modifying
    @Query("UPDATE Loan l SET l.statusId = :newStatusId where l.id =:LoanId")
    void updateLoanStatus(@Param("LoanId") Long loanId  , @Param("newStatusId") int newStatusId);
}
