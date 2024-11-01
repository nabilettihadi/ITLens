package ma.nabil.ITLens.mapper;

import ma.nabil.ITLens.dto.SubjectDTO;
import ma.nabil.ITLens.entity.Subject;
import org.mapstruct.*;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring", uses = {QuestionMapper.class})
public interface SubjectMapper extends GenericMapper<SubjectDTO, Subject> {

    @Override
    @Mapping(target = "surveyId", source = "survey.id")
    @Mapping(target = "parentId", source = "parent.id")
    SubjectDTO toDto(Subject entity);

    @Override
    @Mapping(target = "survey", ignore = true)
    @Mapping(target = "parent", ignore = true)
    @Mapping(target = "children", ignore = true)
    Subject toEntity(SubjectDTO dto);

    @Override
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "parent", ignore = true)
    @Mapping(target = "survey", ignore = true)
    void updateEntity(SubjectDTO dto, @MappingTarget Subject entity);

    default Page<SubjectDTO> toDtoPage(Page<Subject> page) {
        return page.map(this::toDto);
    }
}