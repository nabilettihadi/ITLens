package ma.nabil.ITLens.repository;

import ma.nabil.ITLens.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    Page<Answer> findByQuestionId(Integer questionId, Pageable pageable);
    
    @Query("SELECT a FROM Answer a WHERE a.question.id = :questionId ORDER BY a.selectionCount DESC")
    Page<Answer> findMostSelectedAnswersByQuestionId(Integer questionId, Pageable pageable);
}