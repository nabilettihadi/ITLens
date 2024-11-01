package ma.nabil.ITLens.service;

import ma.nabil.ITLens.dto.QuestionDTO;
import ma.nabil.ITLens.entity.Question;

import java.util.List;

public interface QuestionService extends GenericService<QuestionDTO, Integer> {
    List<QuestionDTO> getQuestionsBySubjectId(Integer subjectId);

    Question getQuestionEntity(Integer id);

    void incrementAnswerCount(Integer questionId);

    QuestionDTO createQuestion(QuestionDTO questionDTO);
}