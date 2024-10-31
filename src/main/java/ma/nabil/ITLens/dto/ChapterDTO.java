package ma.nabil.ITLens.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class ChapterDTO {
    private Integer id;

    @NotBlank(message = "Title is mandatory")
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    private String title;

    @NotNull(message = "Survey ID is mandatory")
    @Positive(message = "Survey ID must be positive")
    private Integer surveyId;

    @Valid
    private List<@NotNull SubChapterDTO> subChapters;
}