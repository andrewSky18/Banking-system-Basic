package crud.crud.domain;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Validated
public class LoginDTO {

    @NotBlank(message = "The Username Should be at most 20 characters and min of 8 characters")
    @Size(max = 20)
    @Size(min = 8)
    private String username;

    @NotBlank(message =  "The password Should be at most 120 characters and min 8 characters ")
    @Size(max = 120)
    @Size(min = 8)
    private String password;
}
