package ma.nabil.ITLens.dto;

import lombok.Data;
import jakarta.validation.constraints.*;

@Data
public class OwnerDTO {
    private Integer id;
    
    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Name must contain only letters and spaces")
    private String name;
}