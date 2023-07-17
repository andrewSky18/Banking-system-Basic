package crud.crud.domain;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO {

    @NotBlank(message = "The name field is required.")
    private String name;

    @NotNull(message = "The national ID field is required.")
    private Long nationalId;

    @NotNull(message = "The age field is required.")
    @Min(value=18, message = "The age must be greater than or equal to 18.")
    private short age;

    @NotNull(message = "The facility ID field is required.")
    private Long facilityId;
}
