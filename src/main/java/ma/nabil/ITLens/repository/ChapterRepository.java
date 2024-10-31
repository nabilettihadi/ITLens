package ma.nabil.ITLens.repository;

import ma.nabil.ITLens.entity.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ChapterRepository extends JpaRepository<Chapter, Integer> {
    Page<Chapter> findBySurveyId(Integer surveyId, Pageable pageable);
}