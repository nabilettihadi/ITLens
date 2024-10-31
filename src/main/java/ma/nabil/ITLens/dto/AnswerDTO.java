package ma.nabil.ITLens.dto;

import lombok.Data;

@Data
public class AnswerDTO {
    private Integer id;
    private String text;
    private Integer selectionCount;
    private Double percentage;
    private Integer questionId;
}