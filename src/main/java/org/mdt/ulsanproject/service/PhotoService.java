package org.mdt.ulsanproject.service;

import org.mdt.ulsanproject.dto.PhotoDto;
import org.mdt.ulsanproject.model.Photo;

import java.util.List;
import java.util.Optional;

public interface PhotoService {
    Photo save(PhotoDto photoDto);
    Optional<Photo> update(int id, PhotoDto photoDto);
    List<Photo> findAll();
    Optional<Photo> findById(int id);
    void delete(int id);
}
