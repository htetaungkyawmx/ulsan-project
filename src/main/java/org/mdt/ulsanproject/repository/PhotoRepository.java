package org.mdt.ulsanproject.repository;

import org.mdt.ulsanproject.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Integer> {
    Optional<Photo> findById(Integer id);
    Optional<Photo> findByTitle(String title);
}
