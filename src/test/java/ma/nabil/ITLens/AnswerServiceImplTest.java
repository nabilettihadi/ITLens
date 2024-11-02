package ma.nabil.ITLens;

import ma.nabil.ITLens.dto.AnswerDTO;
import ma.nabil.ITLens.entity.Answer;
import ma.nabil.ITLens.exception.ResourceNotFoundException;
import ma.nabil.ITLens.mapper.AnswerMapper;
import ma.nabil.ITLens.repository.AnswerRepository;
import ma.nabil.ITLens.service.QuestionService;
import ma.nabil.ITLens.service.impl.AnswerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class AnswerServiceImplTest {

    @Mock
    private AnswerRepository answerRepository;

    @Mock
    private AnswerMapper answerMapper;

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private AnswerServiceImpl answerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAnswersByQuestionId() {
        when(answerRepository.findByQuestionId(1, PageRequest.of(0, 100)))
                .thenReturn(new PageImpl<>(List.of(new Answer())));

        List<AnswerDTO> result = answerService.getAnswersByQuestionId(1);
        assertNotNull(result);
        verify(answerRepository, times(1)).findByQuestionId(1, PageRequest.of(0, 100));
    }

    @Test
    void testIncrementSelectionCount() {
        doNothing().when(answerRepository).incrementSelectionCount(1);

        answerService.incrementSelectionCount(1);
        verify(answerRepository, times(1)).incrementSelectionCount(1);
    }

    @Test
    void testGetAnswerEntity() {
        Answer answer = new Answer();
        when(answerRepository.findById(1)).thenReturn(Optional.of(answer));

        Answer result = answerService.getAnswerEntity(1);
        assertNotNull(result);
        verify(answerRepository, times(1)).findById(1);
    }

    @Test
    void testGetAnswerEntityNotFound() {
        when(answerRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> answerService.getAnswerEntity(1));
    }
}