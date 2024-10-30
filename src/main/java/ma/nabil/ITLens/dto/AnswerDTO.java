package ma.nabil.ITLens.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;

@Data
public class AnswerDTO {
    private Integer id;
    
    @NotBlank(message = "Text is mandatory")
    private String text;
    private Integer selectionCount;
    private Integer questionId;
}