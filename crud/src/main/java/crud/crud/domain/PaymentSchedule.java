package crud.crud.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Internal;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.util.*;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder

@Entity
@Table(name="PaymentSchedule")
public class PaymentSchedule {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private double amount ;

    private Short installmentsNumber ;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "Loan_id")

    private Loan loan;

    public static PaymentSchedule CreatePaymentSchedule(double amounts, int number , LocalDate cdate) {
        PaymentSchedule paymentSchedule = PaymentSchedule.builder()
                .amount(amounts)
                .installmentsNumber((short) (number+1))
                .date(cdate)
                .build();
        return paymentSchedule;
    }
}
