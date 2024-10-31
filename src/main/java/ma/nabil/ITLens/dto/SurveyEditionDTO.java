package ma.nabil.ITLens.dto;

import lombok.Data;
import java.util.Date;

@Data
public class SurveyEditionDTO {
    private Integer id;
    private Date creationDate;
    private Date startDate;
    private Integer year;
    private Integer surveyId;
}