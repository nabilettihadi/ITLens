package ma.nabil.ITLens.repository;

import ma.nabil.ITLens.entity.Survey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SurveyRepository extends JpaRepository<Survey, Integer> {
    Page<Survey> findByOwnerId(Integer ownerId, Pageable pageable);

    @Query("SELECT s FROM Survey s LEFT JOIN FETCH s.chapters c LEFT JOIN FETCH c.subChapters WHERE s.id = :id")
    Survey findByIdWithChapters(Integer id);
}