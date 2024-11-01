package ma.nabil.ITLens.service.impl;

import lombok.RequiredArgsConstructor;
import ma.nabil.ITLens.exception.ResourceNotFoundException;
import ma.nabil.ITLens.mapper.GenericMapper;
import ma.nabil.ITLens.service.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
public abstract class GenericServiceImpl<D, E, ID> implements GenericService<D, ID> {
    protected final JpaRepository<E, ID> repository;
    protected final GenericMapper<D, E> mapper;
    protected final String entityName;

    @Override
    public D create(D dto) {
        E entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public D getById(ID id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException(entityName, "id", id));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<D> getAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDto);
    }

    @Override
    public D update(ID id, D dto) {
        E entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(entityName, "id", id));
        mapper.updateEntity(dto, entity);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Override
    public void delete(ID id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(entityName, "id", id);
        }
        repository.deleteById(id);
    }
}