package ma.nabil.ITLens.service;

import ma.nabil.ITLens.dto.OwnerDTO;
import ma.nabil.ITLens.dto.SurveyDTO;
import ma.nabil.ITLens.entity.Owner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OwnerService extends GenericService<OwnerDTO, Integer> {
    Owner getOwnerEntity(Integer id);
    Page<SurveyDTO> getOwnerSurveys(Integer ownerId, Pageable pageable);
}