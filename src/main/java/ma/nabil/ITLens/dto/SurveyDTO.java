package ma.nabil.ITLens.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Data
public class SurveyDTO {
    private Integer id;
    
    @NotBlank(message = "Title is mandatory")
    @Size(min = 3, max = 100)
    private String title;
    
    @Size(max = 255)
    private String description;
    private Integer ownerId;
}