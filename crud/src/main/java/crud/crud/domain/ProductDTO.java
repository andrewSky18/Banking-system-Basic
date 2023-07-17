package crud.crud.domain;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {
    @NotBlank(message = "The name field is required.")
    private String name;
    @NotNull(message = "The minimum number of repayments field is required.")
    private Short noRepaymentMin;
    @NotNull(message = "The maximum number of repayments field is required.")
    private Short noRepaymentMax;
    @NotNull(message = "The minimum principle field is required.")
    private Long principalMin;
    @NotNull(message = "The maximum principle is required.")
    private Long principalMax;
    @NotNull(message = "The commission field is required.")
    private Long commission;
    @NotNull(message = "The fees field is required.")
    private Long fees;

}
