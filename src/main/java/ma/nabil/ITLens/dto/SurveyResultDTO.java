package ma.nabil.ITLens.dto;

import lombok.Data;
import java.util.List;
import java.util.Map;

@Data
public class SurveyResultDTO {
    private String surveyTitle;
    private List<ChapterResultDTO> chapters;
    
    @Data
    public static class ChapterResultDTO {
        private String title;
        private List<SubChapterResultDTO> subChapters;
    }
    
    @Data
    public static class SubChapterResultDTO {
        private String title;
        private String question;
        private Map<String, Integer> answers;
        private Integer totalAnswers;
    }
}