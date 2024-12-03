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
                .status(photoDto.getStatus())
                .created_at(photoDto.getCreated_at())
                .url(photoDto.getUrl())
                .build();
        return photoRepository.save(photo);
    }

    @Override
    public Photo update(int id, PhotoDto photoDto) {

        return null;
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
