package crud.crud.domain;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.springframework.validation.annotation.Validated;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Validated
public class RegisterDTO {

    @NotBlank
    @Min(value = 1 , message = "The Value either 1 for USER or 2 for Admin")
    @Max(value = 2 , message = "The Value either 1 for USER or 2 for Admin")
    private Short roleId;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank(message = "The Username Should be at most 20 characters and min of 8 characters")
    @Size(max = 20)
    @Size(min = 8)
    private String username;

    @NotBlank(message =  "The password Should be at most 120 characters and min 8 characters ")
    @Size(max = 120)
    @Size(min = 8)
    private String password;

}
