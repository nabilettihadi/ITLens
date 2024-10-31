package ma.nabil.ITLens.dto;

import lombok.Data;
import java.util.List;

@Data
public class SurveyParticipationDTO {
    private List<ResponseDTO> responses;
    
    @Data
    public static class ResponseDTO {
        private Integer questionId;
        private List<Integer> answerIds;
    }
}