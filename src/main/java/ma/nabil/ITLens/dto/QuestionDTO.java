package ma.nabil.ITLens.dto;

import lombok.Data;
import jakarta.validation.constraints.*;
import ma.nabil.ITLens.entity.QuestionType;

@Data
public class QuestionDTO {
    private Integer id;
    
    @NotBlank(message = "Text is mandatory")
    @Size(min = 5, max = 500, message = "Question text must be between 5 and 500 characters")
    private String text;
    
    @PositiveOrZero(message = "Answer count must not be negative")
    private Integer answerCount;
    
    @NotNull(message = "Question type is mandatory")
    private QuestionType type;
    
    @NotNull(message = "Subject ID is mandatory")
    @Positive(message = "Subject ID must be positive")
    private Integer subjectId;
}