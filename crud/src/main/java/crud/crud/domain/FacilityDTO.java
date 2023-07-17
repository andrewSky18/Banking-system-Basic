package crud.crud.domain;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FacilityDTO {
    @NotBlank(message = "The name field is required.")
    private String name;

    @NotNull(message = "The Address field is required.")
    private String address;


}
