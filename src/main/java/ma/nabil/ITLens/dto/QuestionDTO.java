package ma.nabil.ITLens.dto;

import lombok.Data;
import ma.nabil.ITLens.entity.QuestionType;
import java.util.List;

@Data
public class QuestionDTO {
    private Integer id;
    private String text;
    private QuestionType type;
    private Integer answerCount;
    private Integer subChapterId;
    private List<AnswerDTO> answers;
}