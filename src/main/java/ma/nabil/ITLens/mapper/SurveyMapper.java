package ma.nabil.ITLens.mapper;

import ma.nabil.ITLens.dto.SurveyDTO;
import ma.nabil.ITLens.entity.Survey;
import org.mapstruct.*;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring", uses = {SubjectMapper.class, OwnerMapper.class, SurveyEditionMapper.class})
public interface SurveyMapper extends GenericMapper<SurveyDTO, Survey> {

    @Override
    @Mapping(target = "subjects", ignore = true)
    @Mapping(target = "editions", ignore = true)
    Survey toEntity(SurveyDTO dto);

    @Override
    SurveyDTO toDto(Survey entity);

    @Override
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntity(SurveyDTO dto, @MappingTarget Survey entity);

    default Page<SurveyDTO> toDtoPage(Page<Survey> page) {
        return page.map(this::toDto);
    }
}