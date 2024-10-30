package ma.nabil.ITLens.dto;

import lombok.Data;
import jakarta.validation.constraints.*;

@Data
public class SubjectDTO {
    private Integer id;
    
    @NotBlank(message = "Title is mandatory")
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    private String title;
    
    @Positive(message = "Parent subject ID must be positive")
    private Integer parentSubjectId;
}