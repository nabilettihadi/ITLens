package ma.nabil.ITLens.repository;

import ma.nabil.ITLens.entity.Answer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    Page<Answer> findByQuestionId(Integer questionId, Pageable pageable);

    @Query("SELECT a FROM Answer a WHERE a.question.id = :questionId ORDER BY a.selectionCount DESC")
    Page<Answer> findMostSelectedAnswersByQuestionId(Integer questionId, Pageable pageable);

    @Modifying
    @Query("UPDATE Answer a SET a.selectionCount = a.selectionCount + 1 WHERE a.id = :answerId")
    void incrementSelectionCount(@Param("answerId") Integer answerId);
}