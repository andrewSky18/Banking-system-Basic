package crud.crud.domain;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Setter
@Getter
@Builder
@Entity
@Table(name="LoanRequestTracker")
public class LoanRequestTracker {

 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Long id;

 @Column
 @NotBlank
 private String comment;

 @Column
 @NonNull
 private Short actionOpt;


 @ManyToOne
 @JoinColumn(name = "Loan_ID")
 private Loan loanID;


 public static LoanRequestTracker CreateLoanRequestTracker(LoanRequestTrackerDTO loanRequestTrackerDTO, Loan loan) {
  LoanRequestTracker loanRequestTracker = LoanRequestTracker.builder()
          .comment(loanRequestTrackerDTO.getComment())
          .loanID(loan)
          .actionOpt(loanRequestTrackerDTO.getActionOpt())
          .build();
  return loanRequestTracker;
 }
}