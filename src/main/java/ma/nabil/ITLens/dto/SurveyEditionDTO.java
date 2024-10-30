package ma.nabil.ITLens.dto;

import lombok.Data;
import jakarta.validation.constraints.*;
import java.util.Date;

@Data
public class SurveyEditionDTO {
    private Integer id;
    
    @NotNull(message = "Creation date is mandatory")
    @PastOrPresent(message = "Creation date must be in the past or present")
    private Date creationDate;
    
    @Future(message = "Start date must be in the future")
    private Date startDate;
    
    @NotNull(message = "Year is mandatory")
    @Positive(message = "Year must be positive")
    private Integer year;
    
    @NotNull(message = "Survey ID is mandatory")
    @Positive(message = "Survey ID must be positive")
    private Integer surveyId;
}