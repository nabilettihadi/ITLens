package ma.nabil.ITLens.mapper;

import ma.nabil.ITLens.dto.OwnerDTO;
import ma.nabil.ITLens.entity.Owner;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface OwnerMapper extends GenericMapper<OwnerDTO, Owner> {
    
    @Override
    OwnerDTO toDto(Owner entity);
    
    @Override
    Owner toEntity(OwnerDTO dto);
    
    @Override
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntity(OwnerDTO dto, @MappingTarget Owner entity);
}