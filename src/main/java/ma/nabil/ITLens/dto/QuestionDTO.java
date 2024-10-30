package ma.nabil.ITLens.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import ma.nabil.ITLens.entity.QuestionType;

@Data
public class QuestionDTO {
    private Integer id;
    
    @NotBlank(message = "Text is mandatory")
    private String text;
    private Integer answerCount;
    
    @NotNull(message = "Question type is mandatory")
    private QuestionType type;
    private Integer subjectId;
}