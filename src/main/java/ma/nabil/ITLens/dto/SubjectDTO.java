package ma.nabil.ITLens.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;

@Data
public class SubjectDTO {
    private Integer id;
    
    @NotBlank(message = "Title is mandatory")
    private String title;
    private Integer parentSubjectId;
}