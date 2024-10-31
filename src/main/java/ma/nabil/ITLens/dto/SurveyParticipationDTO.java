package ma.nabil.ITLens.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.List;

@Data
public class SurveyParticipationDTO {
    @NotEmpty(message = "Responses list cannot be empty")
    @Valid
    private List<ResponseDTO> responses;

    @Data
    public static class ResponseDTO {
        @NotNull(message = "Question ID is mandatory")
        @Positive(message = "Question ID must be positive")
        private Integer questionId;

        @NotEmpty(message = "Answer IDs list cannot be empty")
        private List<@Positive(message = "Answer ID must be positive") Integer> answerIds;
    }
}