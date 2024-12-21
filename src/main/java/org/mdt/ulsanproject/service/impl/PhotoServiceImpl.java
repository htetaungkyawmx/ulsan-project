package org.mdt.ulsanproject.service.impl;

import org.mdt.ulsanproject.dto.PhotoDto;
import org.mdt.ulsanproject.model.Photo;
import org.mdt.ulsanproject.repository.PhotoRepository;
import org.mdt.ulsanproject.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PhotoServiceImpl implements PhotoService {
    @Autowired
    private PhotoRepository photoRepository;

    @Override
    public Photo save(PhotoDto photoDto) {
        Photo photo = Photo.builder()
                .title(photoDto.getTitle())
                .description(photoDto.getDescription())
                .status(photoDto.getStatus())
                .url(photoDto.getUrl())
                .build();
        return photoRepository.save(photo);
    }

    @Override
    public Optional<Photo> update(int id, PhotoDto photoDto) {
        return photoRepository.findById(id).map(existingPhoto -> {
            existingPhoto.setTitle(photoDto.getTitle());
            existingPhoto.setDescription(photoDto.getDescription());
            existingPhoto.setStatus(photoDto.getStatus());
            existingPhoto.setUrl(photoDto.getUrl());
            return photoRepository.save(existingPhoto);
        });
    }

    @Override
    public Page<Photo> findAll(Pageable pageable) {
        return photoRepository.findAll(pageable);
    }

    @Override
    public Optional<Photo> findById(int id) {
        return photoRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        photoRepository.deleteById(id);
    }
}
