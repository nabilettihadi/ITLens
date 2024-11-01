package ma.nabil.ITLens.service.impl;

import ma.nabil.ITLens.dto.QuestionDTO;
import ma.nabil.ITLens.entity.Question;
import ma.nabil.ITLens.exception.ResourceNotFoundException;
import ma.nabil.ITLens.mapper.QuestionMapper;
import ma.nabil.ITLens.repository.QuestionRepository;
import ma.nabil.ITLens.service.QuestionService;
import ma.nabil.ITLens.service.SubjectService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class QuestionServiceImpl extends GenericServiceImpl<QuestionDTO, Question, Integer> implements QuestionService {
    private final QuestionRepository questionRepository;
    private final SubjectService subjectService;

    public QuestionServiceImpl(QuestionRepository repository, QuestionMapper mapper, SubjectService subjectService) {
        super(repository, mapper, "Question");
        this.questionRepository = repository;
        this.subjectService = subjectService;
    }

    @Override
    public QuestionDTO createQuestion(QuestionDTO questionDTO) {
        Question question = mapper.toEntity(questionDTO);
        question.setSubject(subjectService.getSubjectEntity(questionDTO.getSubjectId()));
        question = questionRepository.save(question);
        return mapper.toDto(question);
    }

    @Override
    @Transactional(readOnly = true)
    public List<QuestionDTO> getQuestionsBySubjectId(Integer subjectId) {
        return questionRepository.findBySubjectId(subjectId, Pageable.unpaged())
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public void incrementAnswerCount(Integer questionId) {
        questionRepository.incrementAnswerCount(questionId);
    }

    @Override
    public Question getQuestionEntity(Integer id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Question", "id", id));
    }
}
