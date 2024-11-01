package ma.nabil.ITLens.service;

import ma.nabil.ITLens.dto.SurveyDTO;
import ma.nabil.ITLens.entity.Survey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SurveyService extends GenericService<SurveyDTO, Integer> {
    Survey getSurveyEntity(Integer id);
    SurveyDTO getSurveyWithSubjects(Integer id);
    Page<SurveyDTO> getSurveysByOwnerId(Integer ownerId, Pageable pageable);
}