package ma.nabil.ITLens.repository;

import ma.nabil.ITLens.entity.Question;
import ma.nabil.ITLens.entity.QuestionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Page<Question> findBySubChapterId(Integer subChapterId, Pageable pageable);
    Page<Question> findBySubChapterIdAndType(Integer subChapterId, QuestionType type, Pageable pageable);
}