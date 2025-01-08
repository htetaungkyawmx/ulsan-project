package org.mdt.ulsanproject.service;

import org.mdt.ulsanproject.dto.PhotoDto;
import org.mdt.ulsanproject.model.Photo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PhotoService {
    Photo save(PhotoDto photoDto, byte[] fileData);
    Optional<Photo> update(int id, PhotoDto photoDto, byte[] fileData);
    Page<Photo> findAll(Pageable pageable); // Added pagination
    Optional<Photo> findById(int id);
    void delete(int id);
}
