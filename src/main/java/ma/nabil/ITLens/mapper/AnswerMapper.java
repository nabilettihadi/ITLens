package ma.nabil.ITLens.mapper;

import ma.nabil.ITLens.dto.AnswerDTO;
import ma.nabil.ITLens.entity.Answer;
import org.mapstruct.*;
import org.springframework.data.domain.Page;

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
    @Mapping(target = "question", ignore = true)
    void updateEntity(AnswerDTO dto, @MappingTarget Answer entity);

    default Page<AnswerDTO> toDtoPage(Page<Answer> page) {
        return page.map(this::toDto);
    }
}