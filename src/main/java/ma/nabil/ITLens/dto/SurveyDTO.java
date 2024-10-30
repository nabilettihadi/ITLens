package ma.nabil.ITLens.dto;

import lombok.Data;
import jakarta.validation.constraints.*;

@Data
public class SurveyDTO {
    private Integer id;
    
    @NotBlank(message = "Title is mandatory")
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    private String title;
    
    @Size(max = 255, message = "Description must be less than 255 characters")
    private String description;
    
    @NotNull(message = "Owner ID is mandatory")
    @Positive(message = "Owner ID must be positive")
    private Integer ownerId;
}