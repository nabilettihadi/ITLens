package ma.nabil.ITLens.service;

import ma.nabil.ITLens.dto.AnswerDTO;
import ma.nabil.ITLens.entity.Answer;

import java.util.List;

public interface AnswerService {
    AnswerDTO createAnswer(AnswerDTO answerDTO);
    AnswerDTO getAnswerById(Integer id);
    List<AnswerDTO> getAnswersByQuestionId(Integer questionId);
    AnswerDTO updateAnswer(Integer id, AnswerDTO answerDTO);
    void deleteAnswer(Integer id);
    Answer getAnswerEntity(Integer id);
}