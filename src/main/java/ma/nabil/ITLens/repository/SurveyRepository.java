package ma.nabil.ITLens.repository;

import ma.nabil.ITLens.entity.Survey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SurveyRepository extends JpaRepository<Survey, Integer> {
    Page<Survey> findByOwnerId(Integer ownerId, Pageable pageable);

    @Query("SELECT s FROM Survey s LEFT JOIN FETCH s.subjects sub LEFT JOIN FETCH sub.children WHERE s.id = :id")
    Survey findByIdWithSubjects(Integer id);
}