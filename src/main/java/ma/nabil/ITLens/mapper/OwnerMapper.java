package ma.nabil.ITLens.mapper;

import ma.nabil.ITLens.dto.OwnerDTO;
import ma.nabil.ITLens.entity.Owner;
import org.mapstruct.*;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface OwnerMapper extends GenericMapper<OwnerDTO, Owner> {

    @Override
    OwnerDTO toDto(Owner entity);

    @Override
    @Mapping(target = "surveys", ignore = true)
    Owner toEntity(OwnerDTO dto);

    @Override
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "surveys", ignore = true)
    void updateEntity(OwnerDTO dto, @MappingTarget Owner entity);

    default Page<OwnerDTO> toDtoPage(Page<Owner> page) {
        return page.map(this::toDto);
    }
}