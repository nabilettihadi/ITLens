package ma.nabil.ITLens.dto;

import lombok.Data;
import jakarta.validation.constraints.*;

@Data
public class AnswerDTO {
    private Integer id;
    
    @NotBlank(message = "Text is mandatory")
    @Size(min = 1, max = 255, message = "Answer text must be between 1 and 255 characters")
    private String text;
    
    @PositiveOrZero(message = "Selection count must not be negative")
    private Integer selectionCount;
    
    @NotNull(message = "Question ID is mandatory")
    @Positive(message = "Question ID must be positive")
    private Integer questionId;
}