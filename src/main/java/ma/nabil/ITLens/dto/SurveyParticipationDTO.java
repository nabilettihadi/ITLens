package ma.nabil.ITLens.dto;

import lombok.Data;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;
import java.util.List;

@Data
public class SurveyParticipationDTO {
    @NotEmpty(message = "Responses cannot be empty")
    @Valid
    private List<ResponseDTO> responses;
    
    @Data
    public static class ResponseDTO {
        @NotNull(message = "Question ID is mandatory")
        @Positive(message = "Question ID must be positive")
        private Integer questionId;
        
        private String answerId;
        
        @Valid
        private List<AnswerSelectionDTO> answers;
    }
    
    @Data
    public static class AnswerSelectionDTO {
        @NotBlank(message = "Answer ID is mandatory")
        private String answerId;
    }
}