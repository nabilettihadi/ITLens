package ma.nabil.ITLens.service;

import ma.nabil.ITLens.dto.QuestionDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QuestionService {
    QuestionDTO createQuestion(QuestionDTO questionDTO);

    Page<QuestionDTO> getAllQuestions(Pageable pageable);

    QuestionDTO getQuestionById(Integer id);

    void deleteQuestion(Integer id);

    QuestionDTO updateQuestion(Integer id, QuestionDTO questionDTO);

    List<QuestionDTO> getQuestionsBySubjectId(Integer subjectId);
}