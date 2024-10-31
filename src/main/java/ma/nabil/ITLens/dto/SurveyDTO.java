package ma.nabil.ITLens.dto;

import lombok.Data;
import java.util.List;

@Data
public class SurveyDTO {
    private Integer id;
    private String title;
    private String description;
    private OwnerDTO owner;
    private List<ChapterDTO> chapters;
    private List<SurveyEditionDTO> editions;
}