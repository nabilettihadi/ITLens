package ma.nabil.ITLens.mapper;

import ma.nabil.ITLens.dto.SurveyDTO;
import ma.nabil.ITLens.entity.Survey;
import org.mapstruct.*;

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
}