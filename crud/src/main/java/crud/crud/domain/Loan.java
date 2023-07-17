package crud.crud.domain;
import crud.crud.repo.IcustomerRepository;
import crud.crud.repo.IproductRepository;
import jakarta.persistence.*;
import lombok.*;

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

    private int amount;

    private short noOfLoanRepayment;

    public static Loan CreateLoan(LoanDTO loanDTO,Customer customer , Product product) {
        Loan loan = Loan.builder()
                .customer(customer)
                .product(product)
                .amount(loanDTO.getAmount())
                .noOfLoanRepayment(loanDTO.getNoOfLoanRepayment())
                .build();
        return loan;
    }
}