package ma.nabil.ITLens.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class SurveyEditionDTO {
    private Integer id;

    @NotNull(message = "Creation date is mandatory")
    private Date creationDate;

    @NotNull(message = "Start date is mandatory")
    @FutureOrPresent(message = "Start date must be in present or future")
    private Date startDate;

    @NotNull(message = "Year is mandatory")
    private Integer year;

    @NotNull(message = "Survey ID is mandatory")
    private Integer surveyId;
}