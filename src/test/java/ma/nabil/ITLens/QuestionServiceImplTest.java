package ma.nabil.ITLens;

import ma.nabil.ITLens.entity.Question;
import ma.nabil.ITLens.exception.ResourceNotFoundException;
import ma.nabil.ITLens.mapper.QuestionMapper;
import ma.nabil.ITLens.repository.QuestionRepository;
import ma.nabil.ITLens.service.impl.QuestionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class QuestionServiceImplTest {

    @Mock
    private QuestionRepository questionRepository;

    @Mock
    private QuestionMapper questionMapper;

    @InjectMocks
    private QuestionServiceImpl questionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetQuestionEntity() {
        Question question = new Question();
        when(questionRepository.findById(1)).thenReturn(Optional.of(question));

        Question result = questionService.getQuestionEntity(1);
        assertNotNull(result);
        verify(questionRepository, times(1)).findById(1);
    }

    @Test
    void testGetQuestionEntityNotFound() {
        when(questionRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> questionService.getQuestionEntity(1));
    }
}