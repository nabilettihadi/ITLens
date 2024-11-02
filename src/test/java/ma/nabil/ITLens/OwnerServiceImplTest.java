package ma.nabil.ITLens;

import ma.nabil.ITLens.dto.OwnerDTO;
import ma.nabil.ITLens.dto.SurveyDTO;
import ma.nabil.ITLens.entity.Owner;
import ma.nabil.ITLens.entity.Survey;
import ma.nabil.ITLens.exception.ResourceNotFoundException;
import ma.nabil.ITLens.mapper.OwnerMapper;
import ma.nabil.ITLens.mapper.SurveyMapper;
import ma.nabil.ITLens.repository.OwnerRepository;
import ma.nabil.ITLens.repository.SurveyRepository;
import ma.nabil.ITLens.service.impl.OwnerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OwnerServiceImplTest {

    @Mock
    private OwnerRepository ownerRepository;

    @Mock
    private SurveyRepository surveyRepository;

    @Mock
    private OwnerMapper ownerMapper;

    @Mock
    private SurveyMapper surveyMapper;

    @InjectMocks
    private OwnerServiceImpl ownerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetOwnerEntity() {
        Owner owner = new Owner();
        when(ownerRepository.findById(1)).thenReturn(Optional.of(owner));

        Owner result = ownerService.getOwnerEntity(1);
        assertNotNull(result);
        verify(ownerRepository, times(1)).findById(1);
    }

    @Test
    void testGetOwnerEntityNotFound() {
        when(ownerRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> ownerService.getOwnerEntity(1));
    }

    @Test
    void testGetOwnerSurveys() {
        Page<Survey> page = new PageImpl<>(List.of(new Survey()));
        when(surveyRepository.findByOwnerId(1, PageRequest.of(0, 10))).thenReturn(page);

        
        Page<SurveyDTO> result = ownerService.getOwnerSurveys(1, PageRequest.of(0, 10));
        assertNotNull(result);
        verify(surveyRepository, times(1)).findByOwnerId(1, PageRequest.of(0, 10));
    }
}