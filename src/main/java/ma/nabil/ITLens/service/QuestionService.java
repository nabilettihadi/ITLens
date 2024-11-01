package ma.nabil.ITLens.service;

import ma.nabil.ITLens.dto.QuestionDTO;
import ma.nabil.ITLens.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QuestionService extends GenericService<QuestionDTO, Integer> {
    List<QuestionDTO> getQuestionsBySubjectId(Integer subjectId);
    Question getQuestionEntity(Integer id);
    void incrementAnswerCount(Integer questionId);
}