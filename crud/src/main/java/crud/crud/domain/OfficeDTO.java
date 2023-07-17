package crud.crud.domain;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OfficeDTO {

    @NotBlank(message = "The Name is Required Field to Insert")
    private String name;

}
