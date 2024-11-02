package ma.nabil.ITLens;

import ma.nabil.ITLens.dto.SurveyDTO;
import ma.nabil.ITLens.entity.Survey;
import ma.nabil.ITLens.exception.ResourceNotFoundException;
import ma.nabil.ITLens.mapper.SurveyMapper;
import ma.nabil.ITLens.repository.SurveyRepository;
import ma.nabil.ITLens.service.impl.SurveyServiceImpl;
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

class SurveyServiceImplTest {

    @Mock
    private SurveyRepository surveyRepository;

    @Mock
    private SurveyMapper surveyMapper;

    @InjectMocks
    private SurveyServiceImpl surveyService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetSurveyEntity() {
        Survey survey = new Survey();
        when(surveyRepository.findById(1)).thenReturn(Optional.of(survey));

        Survey result = surveyService.getSurveyEntity(1);
        assertNotNull(result);
        verify(surveyRepository, times(1)).findById(1);
    }

    @Test
    void testGetSurveyEntityNotFound() {
        when(surveyRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> surveyService.getSurveyEntity(1));
    }

    @Test
    void testGetSurveysByOwnerId() {
        Page<Survey> page = new PageImpl<>(List.of(new Survey()));
        when(surveyRepository.findByOwnerId(1, PageRequest.of(0, 10))).thenReturn(page);

        Page<SurveyDTO> result = surveyService.getSurveysByOwnerId(1, PageRequest.of(0, 10));
        assertNotNull(result);
        verify(surveyRepository, times(1)).findByOwnerId(1, PageRequest.of(0, 10));
    }

    @Test
    void testGetSurveyWithSubjects() {
        Survey survey = new Survey();
        when(surveyRepository.findByIdWithSubjects(1)).thenReturn(survey);
        when(surveyMapper.toDto(survey)).thenReturn(new SurveyDTO());

        SurveyDTO result = surveyService.getSurveyWithSubjects(1);
        assertNotNull(result);
        verify(surveyRepository, times(1)).findByIdWithSubjects(1);
    }
}