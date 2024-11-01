package ma.nabil.ITLens.mapper;

import ma.nabil.ITLens.dto.SurveyEditionDTO;
import ma.nabil.ITLens.entity.SurveyEdition;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface SurveyEditionMapper extends GenericMapper<SurveyEditionDTO, SurveyEdition> {
    
    @Override
    @Mapping(target = "surveyId", source = "survey.id")
    SurveyEditionDTO toDto(SurveyEdition entity);
    
    @Override
    @Mapping(target = "survey", ignore = true)
    SurveyEdition toEntity(SurveyEditionDTO dto);
    
    @Override
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntity(SurveyEditionDTO dto, @MappingTarget SurveyEdition entity);
}