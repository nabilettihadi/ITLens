package ma.nabil.ITLens.service;

import ma.nabil.ITLens.dto.SurveyDTO;
import ma.nabil.ITLens.entity.Survey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SurveyService {
    SurveyDTO createSurvey(SurveyDTO surveyDTO);
    Page<SurveyDTO> getAllSurveys(Pageable pageable);
    SurveyDTO getSurveyById(Integer id);
    void deleteSurvey(Integer id);
    SurveyDTO updateSurvey(Integer id, SurveyDTO surveyDTO);
    Survey getSurveyEntity(Integer id);
    SurveyDTO getSurveyWithSubjects(Integer id);
}