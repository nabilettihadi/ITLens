package ma.nabil.ITLens.repository;

import ma.nabil.ITLens.entity.Question;
import ma.nabil.ITLens.entity.QuestionType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Page<Question> findBySubjectId(Integer subjectId, Pageable pageable);

    Page<Question> findBySubjectIdAndType(Integer subjectId, QuestionType type, Pageable pageable);
    @Modifying
@Query("UPDATE Question q SET q.answerCount = q.answerCount + 1 WHERE q.id = :questionId")
void incrementAnswerCount(@Param("questionId") Integer questionId);
}