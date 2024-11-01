package ma.nabil.ITLens.service.impl;

import ma.nabil.ITLens.dto.AnswerDTO;
import ma.nabil.ITLens.entity.Answer;
import ma.nabil.ITLens.exception.ResourceNotFoundException;
import ma.nabil.ITLens.mapper.AnswerMapper;
import ma.nabil.ITLens.repository.AnswerRepository;
import ma.nabil.ITLens.service.AnswerService;
import ma.nabil.ITLens.service.QuestionService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AnswerServiceImpl extends GenericServiceImpl<AnswerDTO, Answer, Integer> implements AnswerService {
    private final AnswerRepository answerRepository;
    private final QuestionService questionService;
    private final AnswerMapper mapper;

    public AnswerServiceImpl(AnswerRepository repository, AnswerMapper mapper, QuestionService questionService) {
        super(repository, mapper, "Answer");
        this.answerRepository = repository;
        this.mapper = mapper;
        this.questionService = questionService;
    }

    @Override
    @Transactional(readOnly = true)
    public List<AnswerDTO> getAnswersByQuestionId(Integer questionId) {
        return answerRepository.findByQuestionId(questionId, PageRequest.of(0, 100))  // 100 éléments par page
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public void incrementSelectionCount(Integer answerId) {
        answerRepository.incrementSelectionCount(answerId);
    }

    @Override
    public Answer getAnswerEntity(Integer id) {
        return answerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Answer", "id", id));
    }
}