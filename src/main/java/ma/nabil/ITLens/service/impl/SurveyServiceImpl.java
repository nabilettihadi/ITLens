package ma.nabil.ITLens.service.impl;

import ma.nabil.ITLens.dto.SurveyDTO;
import ma.nabil.ITLens.entity.Survey;
import ma.nabil.ITLens.exception.ResourceNotFoundException;
import ma.nabil.ITLens.mapper.SurveyMapper;
import ma.nabil.ITLens.repository.SurveyRepository;
import ma.nabil.ITLens.service.SurveyService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SurveyServiceImpl extends GenericServiceImpl<SurveyDTO, Survey, Integer> implements SurveyService {
    private final SurveyRepository surveyRepository;
    private final SurveyMapper mapper;

    public SurveyServiceImpl(SurveyRepository repository, SurveyMapper mapper) {
        super(repository, mapper, "Survey");
        this.surveyRepository = repository;
        this.mapper = mapper;
    }

    @Override
    public Survey getSurveyEntity(Integer id) {
        return surveyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Survey", "id", id));
    }

    @Override
    @Transactional(readOnly = true)
    public SurveyDTO getSurveyWithSubjects(Integer id) {
        Survey survey = surveyRepository.findByIdWithSubjects(id);
        if (survey == null) {
            throw new ResourceNotFoundException("Survey", "id", id);
        }
        return mapper.toDto(survey);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<SurveyDTO> getSurveysByOwnerId(Integer ownerId, Pageable pageable) {
        return surveyRepository.findByOwnerId(ownerId, pageable)
                .map(mapper::toDto);
    }
}