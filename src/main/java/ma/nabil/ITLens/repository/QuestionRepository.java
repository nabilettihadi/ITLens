package ma.nabil.ITLens.repository;

import ma.nabil.ITLens.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}