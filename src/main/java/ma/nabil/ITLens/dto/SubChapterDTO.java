package ma.nabil.ITLens.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class SubChapterDTO {
    private Integer id;

    @NotBlank(message = "Title is mandatory")
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    private String title;

    @NotNull(message = "Chapter ID is mandatory")
    @Positive(message = "Chapter ID must be positive")
    private Integer chapterId;

    @Valid
    private List<@NotNull QuestionDTO> questions;
}