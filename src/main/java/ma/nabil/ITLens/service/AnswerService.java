package ma.nabil.ITLens.service;

import ma.nabil.ITLens.dto.AnswerDTO;
import ma.nabil.ITLens.entity.Answer;

import java.util.List;

public interface AnswerService extends GenericService<AnswerDTO, Integer> {
    List<AnswerDTO> getAnswersByQuestionId(Integer questionId);

    Answer getAnswerEntity(Integer id);

    void incrementSelectionCount(Integer answerId);
}