package org.mdt.ulsanproject.service.impl;

import org.mdt.ulsanproject.dto.PhotoDto;
import org.mdt.ulsanproject.model.Photo;
import org.mdt.ulsanproject.repository.PhotoRepository;
import org.mdt.ulsanproject.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
                .url(photoDto.getUrl())
                .build();
        return photoRepository.save(photo);
    }

    @Override
    public Optional<Photo> update(int id, PhotoDto photoDto) {
        Optional<Photo> optionalPhoto = photoRepository.findById(id);
        if (optionalPhoto.isPresent()) {
            Photo photo = optionalPhoto.get();
            if (photoDto.getTitle() != null) photo.setTitle(photoDto.getTitle());
            if (photoDto.getDescription() != null) photo.setDescription(photoDto.getDescription());
            if (photoDto.getUrl() != null) photo.setUrl(photoDto.getUrl());
            return Optional.of(photoRepository.save(photo));
        }
        return Optional.empty();
    }

    @Override
    public List<Photo> findAll() {
        return photoRepository.findAll();
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
