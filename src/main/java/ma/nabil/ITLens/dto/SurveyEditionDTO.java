package ma.nabil.ITLens.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

@Data
public class SurveyEditionDTO {
    private Integer id;
    
    @NotNull(message = "Creation date is mandatory")
    private Date creationDate;
    private Date startDate;
    private Integer year;
    private Integer surveyId;
}