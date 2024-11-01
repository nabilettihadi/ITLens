package ma.nabil.ITLens.service.impl;

import ma.nabil.ITLens.dto.SurveyEditionDTO;
import ma.nabil.ITLens.entity.SurveyEdition;
import ma.nabil.ITLens.exception.ResourceNotFoundException;
import ma.nabil.ITLens.mapper.SurveyEditionMapper;
import ma.nabil.ITLens.repository.SurveyEditionRepository;
import ma.nabil.ITLens.service.SurveyEditionService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SurveyEditionServiceImpl extends GenericServiceImpl<SurveyEditionDTO, SurveyEdition, Integer> implements SurveyEditionService {
    private final SurveyEditionRepository surveyEditionRepository;
    private final SurveyEditionMapper mapper;

    public SurveyEditionServiceImpl(SurveyEditionRepository repository, SurveyEditionMapper mapper) {
        super(repository, mapper, "SurveyEdition");
        this.surveyEditionRepository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<SurveyEditionDTO> getEditionsBySurveyId(Integer surveyId) {
        return surveyEditionRepository.findBySurveyId(surveyId, Pageable.unpaged())
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public SurveyEditionDTO getCurrentEdition(Integer surveyId) {
        return surveyEditionRepository.findBySurveyId(surveyId, PageRequest.of(0, 1))
                .stream()
                .findFirst()
                .map(mapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("SurveyEdition", "surveyId", surveyId));
    }

    @Override
    public SurveyEdition getSurveyEditionEntity(Integer id) {
        return surveyEditionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SurveyEdition", "id", id));
    }
}