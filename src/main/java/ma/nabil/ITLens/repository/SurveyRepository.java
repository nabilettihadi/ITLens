package ma.nabil.ITLens.repository;

import ma.nabil.ITLens.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<Survey, Integer> {
}