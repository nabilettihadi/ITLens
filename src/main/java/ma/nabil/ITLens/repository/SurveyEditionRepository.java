package ma.nabil.ITLens.repository;

import ma.nabil.ITLens.entity.SurveyEdition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyEditionRepository extends JpaRepository<SurveyEdition, Integer> {
    Page<SurveyEdition> findBySurveyId(Integer surveyId, Pageable pageable);

    Page<SurveyEdition> findByYear(Integer year, Pageable pageable);
}