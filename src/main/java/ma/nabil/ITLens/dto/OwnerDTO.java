package ma.nabil.ITLens.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;

@Data
public class OwnerDTO {
    private Integer id;
    
    @NotBlank(message = "Name is mandatory")
    private String name;
}