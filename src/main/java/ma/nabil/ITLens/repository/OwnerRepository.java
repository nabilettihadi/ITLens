package ma.nabil.ITLens.repository;

import ma.nabil.ITLens.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {
    Page<Owner> findByNameContainingIgnoreCase(String name, Pageable pageable);
}