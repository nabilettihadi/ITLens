package ma.nabil.ITLens.service.impl;

import ma.nabil.ITLens.dto.SubjectDTO;
import ma.nabil.ITLens.entity.Subject;
import ma.nabil.ITLens.exception.ResourceNotFoundException;
import ma.nabil.ITLens.mapper.SubjectMapper;
import ma.nabil.ITLens.repository.SubjectRepository;
import ma.nabil.ITLens.service.SubjectService;
import ma.nabil.ITLens.service.SurveyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SubjectServiceImpl extends GenericServiceImpl<SubjectDTO, Subject, Integer> implements SubjectService {
    private final SubjectRepository subjectRepository;
    private final SurveyService surveyService;
    private final SubjectMapper mapper;

    public SubjectServiceImpl(SubjectRepository repository, SubjectMapper mapper, SurveyService surveyService) {
        super(repository, mapper, "Subject");
        this.subjectRepository = repository;
        this.mapper = mapper;
        this.surveyService = surveyService;
    }

    @Override
    @Transactional(readOnly = true)
    public List<SubjectDTO> getRootSubjects(Integer surveyId) {
        return subjectRepository.findBySurveyIdAndParentIsNull(surveyId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<SubjectDTO> getChildSubjects(Integer parentId) {
        Subject parent = getSubjectEntity(parentId);
        return parent.getChildren()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public Subject getSubjectEntity(Integer id) {
        return subjectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subject", "id", id));
    }

    @Override
    public SubjectDTO addChildSubject(Integer parentId, SubjectDTO childDTO) {
        Subject parent = getSubjectEntity(parentId);
        Subject child = mapper.toEntity(childDTO);
        child.setParent(parent);
        child.setSurvey(parent.getSurvey());
        child = subjectRepository.save(child);
        return mapper.toDto(child);
    }

    @Override
    public SubjectDTO create(SubjectDTO dto) {
        Subject subject = mapper.toEntity(dto);
        subject.setSurvey(surveyService.getSurveyEntity(dto.getSurveyId()));
        if (dto.getParentId() != null) {
            subject.setParent(getSubjectEntity(dto.getParentId()));
        }
        subject = subjectRepository.save(subject);
        return mapper.toDto(subject);
    }

    @Override
    public SubjectDTO update(Integer id, SubjectDTO dto) {
        Subject subject = getSubjectEntity(id);
        mapper.updateEntity(dto, subject);
        if (dto.getSurveyId() != null) {
            subject.setSurvey(surveyService.getSurveyEntity(dto.getSurveyId()));
        }
        if (dto.getParentId() != null) {
            subject.setParent(getSubjectEntity(dto.getParentId()));
        }
        subject = subjectRepository.save(subject);
        return mapper.toDto(subject);
    }
}