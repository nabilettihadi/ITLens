package ma.nabil.ITLens.dto;

import lombok.Data;
import java.util.List;

@Data
public class ChapterDTO {
    private Integer id;
    private String title;
    private Integer surveyId;
    private List<SubChapterDTO> subChapters;
}