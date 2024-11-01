package ma.nabil.ITLens.mapper;

import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

import java.util.List;

public interface GenericMapper<D, E> {
    D toDto(E entity);
    E toEntity(D dto);
    List<D> toDtoList(List<E> entities);
    List<E> toEntityList(List<D> dtos);
    Page<D> toDtoPage(Page<E> entities);
    void updateEntity(D dto, @MappingTarget E entity);
}