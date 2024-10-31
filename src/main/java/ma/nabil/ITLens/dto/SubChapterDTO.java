package ma.nabil.ITLens.dto;

import lombok.Data;
import java.util.List;

@Data
public class SubChapterDTO {
    private Integer id;
    private String title;
    private Integer chapterId;
    private List<QuestionDTO> questions;
}