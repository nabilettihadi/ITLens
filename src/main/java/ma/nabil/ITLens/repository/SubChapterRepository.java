package ma.nabil.ITLens.repository;

import ma.nabil.ITLens.entity.SubChapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SubChapterRepository extends JpaRepository<SubChapter, Integer> {
    Page<SubChapter> findByChapterId(Integer chapterId, Pageable pageable);
}