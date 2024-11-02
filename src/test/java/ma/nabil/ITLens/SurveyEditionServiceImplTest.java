package ma.nabil.ITLens;

import ma.nabil.ITLens.dto.SurveyEditionDTO;
import ma.nabil.ITLens.entity.SurveyEdition;
import ma.nabil.ITLens.exception.ResourceNotFoundException;
import ma.nabil.ITLens.mapper.SurveyEditionMapper;
import ma.nabil.ITLens.repository.SurveyEditionRepository;
import ma.nabil.ITLens.service.impl.SurveyEditionServiceImpl;
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

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class SurveyEditionServiceImplTest {

    @Mock
    private SurveyEditionRepository surveyEditionRepository;

    @Mock
    private SurveyEditionMapper surveyEditionMapper;

    @InjectMocks
    private SurveyEditionServiceImpl surveyEditionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetEditionsBySurveyId() {
        Page<SurveyEdition> page = new PageImpl<>(List.of(new SurveyEdition()));
        when(surveyEditionRepository.findBySurveyId(1, PageRequest.of(0, 10)))
                .thenReturn(page);

        List<SurveyEditionDTO> result = surveyEditionService.getEditionsBySurveyId(1);
        assertNotNull(result);
        verify(surveyEditionRepository, times(1)).findBySurveyId(1, PageRequest.of(0, 10));
    }

    @Test
    void testGetCurrentEdition() {
        SurveyEdition surveyEdition = new SurveyEdition();
        when(surveyEditionRepository.findBySurveyId(1, PageRequest.of(0, 1)))
                .thenReturn(new PageImpl<>(List.of(surveyEdition)));
        when(surveyEditionMapper.toDto(surveyEdition)).thenReturn(new SurveyEditionDTO());

        SurveyEditionDTO result = surveyEditionService.getCurrentEdition(1);
        assertNotNull(result);
        verify(surveyEditionRepository, times(1)).findBySurveyId(1, PageRequest.of(0, 1));
    }

    @Test
    void testGetSurveyEditionEntity() {
        SurveyEdition surveyEdition = new SurveyEdition();
        when(surveyEditionRepository.findById(1)).thenReturn(Optional.of(surveyEdition));

        SurveyEdition result = surveyEditionService.getSurveyEditionEntity(1);
        assertNotNull(result);
        verify(surveyEditionRepository, times(1)).findById(1);
    }

    @Test
    void testGetSurveyEditionEntityNotFound() {
        when(surveyEditionRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> surveyEditionService.getSurveyEditionEntity(1));
    }
}