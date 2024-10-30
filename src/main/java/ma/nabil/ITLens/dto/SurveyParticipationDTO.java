package ma.nabil.ITLens.dto;

import lombok.Data;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class SurveyParticipationDTO {
    @NotEmpty(message = "Responses cannot be empty")
    private List<ResponseDTO> responses;
    
    @Data
    public static class ResponseDTO {
        private Integer questionId;
        private String answerId;
        private List<AnswerSelectionDTO> answers;
    }
    
    @Data
    public static class AnswerSelectionDTO {
        private String answerId;
    }
}