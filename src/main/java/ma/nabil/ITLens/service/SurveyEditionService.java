package ma.nabil.ITLens.service;

import ma.nabil.ITLens.dto.SurveyEditionDTO;
import ma.nabil.ITLens.entity.SurveyEdition;

import java.util.List;

public interface SurveyEditionService extends GenericService<SurveyEditionDTO, Integer> {
    List<SurveyEditionDTO> getEditionsBySurveyId(Integer surveyId);

    SurveyEditionDTO getCurrentEdition(Integer surveyId);

    SurveyEdition getSurveyEditionEntity(Integer id);
}
