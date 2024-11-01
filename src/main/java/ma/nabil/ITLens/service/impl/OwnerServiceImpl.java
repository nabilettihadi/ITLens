package ma.nabil.ITLens.service.impl;

import ma.nabil.ITLens.dto.OwnerDTO;
import ma.nabil.ITLens.dto.SurveyDTO;
import ma.nabil.ITLens.entity.Owner;
import ma.nabil.ITLens.exception.ResourceNotFoundException;
import ma.nabil.ITLens.mapper.OwnerMapper;
import ma.nabil.ITLens.mapper.SurveyMapper;
import ma.nabil.ITLens.repository.OwnerRepository;
import ma.nabil.ITLens.repository.SurveyRepository;
import ma.nabil.ITLens.service.OwnerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OwnerServiceImpl extends GenericServiceImpl<OwnerDTO, Owner, Integer> implements OwnerService {
    private final OwnerRepository ownerRepository;
    private final SurveyRepository surveyRepository;
    private final SurveyMapper surveyMapper;
    private final OwnerMapper ownerMapper;

    // Gardez uniquement ce constructeur
    public OwnerServiceImpl(OwnerRepository ownerRepository, OwnerMapper ownerMapper,
                            SurveyRepository surveyRepository, SurveyMapper surveyMapper) {
        super(ownerRepository, ownerMapper, "Owner");
        this.ownerRepository = ownerRepository;
        this.surveyRepository = surveyRepository;
        this.surveyMapper = surveyMapper;
        this.ownerMapper = ownerMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<SurveyDTO> getOwnerSurveys(Integer ownerId, Pageable pageable) {
        return surveyRepository.findByOwnerId(ownerId, pageable)
                .map(surveyMapper::toDto);
    }

    @Override
    public Owner getOwnerEntity(Integer id) {
        return ownerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Owner", "id", id));
    }
}