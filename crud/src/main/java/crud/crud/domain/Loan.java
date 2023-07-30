package crud.crud.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import crud.crud.repo.IcustomerRepository;
import crud.crud.repo.IproductRepository;
import crud.crud.service.LoanRequestTrackerService;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Builder
@Table(name="Loan")
public class Loan {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Customer_id")
    private Customer customer;

    //col. name
    @ManyToOne
    @JoinColumn(name = "Product_id")
    private Product product;

    @Column
    private int amount;
    @Column
    private short noOfLoanRepayment;

    @Column
    private int statusId;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "loanRequestTracker_id")
    @JsonIgnore
    private List<LoanRequestTracker> trackers ;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "LoanRequestTrackerService_id")
    @JsonIgnore
    private Set<LoanRequestTracker> loanRequestTrackerServiceId;

    public static Loan CreateLoan(LoanDTO loanDTO,Customer customer , Product product) {
        Loan loan = Loan.builder()
                .customer(customer)
                .product(product)
                .amount(loanDTO.getAmount())
                .noOfLoanRepayment(loanDTO.getNoOfLoanRepayment())
                .statusId(LoanStatus.CREATED.getCode())
                .build();
        return loan;
    }

}