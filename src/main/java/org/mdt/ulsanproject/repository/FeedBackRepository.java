package org.mdt.ulsanproject.repository;

import org.mdt.ulsanproject.model.FeedBack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeedBackRepository extends JpaRepository<FeedBack, Integer> {
    // Correct the method signature: findById should return Optional<FeedBack> with Integer id
    Optional<FeedBack> findById(Integer id);
}
