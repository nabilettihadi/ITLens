package ma.nabil.ITLens.mapper;

import ma.nabil.ITLens.dto.QuestionDTO;
import ma.nabil.ITLens.entity.Question;
import org.mapstruct.*;
import org.springframework.data.domain.Page;

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
    @Mapping(target = "subject", ignore = true)
    void updateEntity(QuestionDTO dto, @MappingTarget Question entity);

    default Page<QuestionDTO> toDtoPage(Page<Question> page) {
        return page.map(this::toDto);
    }
}