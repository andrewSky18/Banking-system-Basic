package crud.crud.domain;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoanDTO {

    @NotNull(message = "The amount field is required.")
    private Integer amount;
    @NotNull(message = "The Number of loan repayment field is required.")
    private Short  noOfLoanRepayment;
    @NotNull(message = "The Customer Id field is required.")
    private Long customerId;
    @NotNull(message = "The Product Id field is required.")
    private Long productId ;

}
