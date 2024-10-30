package ma.nabil.ITLens.dto;

import lombok.Data;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;

@Data
public class SurveyResultDTO {
    @NotBlank(message = "Survey title is mandatory")
    private String surveyTitle;
    
    @NotEmpty(message = "Chapters cannot be empty")
    private List<ChapterResultDTO> chapters;
    
    @Data
    public static class ChapterResultDTO {
        @NotBlank(message = "Chapter title is mandatory")
        private String title;
        
        @NotNull(message = "Sub-chapters list cannot be null")
        private List<SubChapterResultDTO> subChapters;
    }
    
    @Data
    public static class SubChapterResultDTO {
        @NotBlank(message = "Sub-chapter title is mandatory")
        private String title;
        
        @NotBlank(message = "Question text is mandatory")
        private String question;
        
        @NotNull(message = "Answers map cannot be null")
        private Map<String, Integer> answers;
        
        @PositiveOrZero(message = "Total answers must not be negative")
        private Integer totalAnswers;
    }
}