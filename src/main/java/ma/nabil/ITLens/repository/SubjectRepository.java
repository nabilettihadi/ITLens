package ma.nabil.ITLens.repository;

import ma.nabil.ITLens.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    List<Subject> findBySurveyIdAndParentIsNull(Integer surveyId);

    @Query("SELECT s FROM Subject s LEFT JOIN FETCH s.children WHERE s.id = :id")
    Subject findByIdWithChildren(Integer id);
}