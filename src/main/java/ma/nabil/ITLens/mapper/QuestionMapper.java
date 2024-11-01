package ma.nabil.ITLens.mapper;

import ma.nabil.ITLens.dto.QuestionDTO;
import ma.nabil.ITLens.entity.Question;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {AnswerMapper.class})
public interface QuestionMapper extends GenericMapper<QuestionDTO, Question> {
    
    @Override
    @Mapping(target = "subjectId", source = "subject.id")
    QuestionDTO toDto(Question entity);
    
    @Override
    @Mapping(target = "subject", ignore = true)
    @Mapping(target = "answers", ignore = true)
    Question toEntity(QuestionDTO dto);
    
    @Override
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntity(QuestionDTO dto, @MappingTarget Question entity);
}