package crud.crud.domain;


import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoanRequestTrackerDTO {


    @NotBlank(message = "The Comment field is required.")
    private String comment;

    @NotNull(message = "The Action value field is required.")
    @Min(value = 1, message = "Insert 1 for Accepted or 2 for Rejected")
    @Max(value = 2, message = "Insert 1 for Accepted or 2 for Rejected")
    private Short actionOpt;

    @NotNull(message = "The Loan Id field is required.")
    private Long loanId ;
}
