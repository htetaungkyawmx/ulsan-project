package org.mdt.ulsanproject.repository;

import org.mdt.ulsanproject.model.FeedBack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeedBackRepository extends JpaRepository<FeedBack, Integer> {
    Optional<FeedBack> findById(Integer id);
}
