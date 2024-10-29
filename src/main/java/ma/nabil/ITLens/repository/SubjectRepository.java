package ma.nabil.ITLens.repository;

import ma.nabil.ITLens.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}