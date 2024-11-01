package ma.nabil.ITLens.mapper;

import ma.nabil.ITLens.dto.AnswerDTO;
import ma.nabil.ITLens.entity.Answer;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface AnswerMapper extends GenericMapper<AnswerDTO, Answer> {
    
    @Override
    @Mapping(target = "questionId", source = "question.id")
    AnswerDTO toDto(Answer entity);
    
    @Override
    @Mapping(target = "question", ignore = true)
    Answer toEntity(AnswerDTO dto);
    
    @Override
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntity(AnswerDTO dto, @MappingTarget Answer entity);
}