package org.mdt.ulsanproject.controller;

import jakarta.validation.Valid;
import org.mdt.ulsanproject.dto.PhotoDto;
import org.mdt.ulsanproject.model.Photo;
import org.mdt.ulsanproject.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/photos/")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @PostMapping
    public ResponseEntity<Photo> create(@Valid @RequestBody PhotoDto photoDto) {
        Photo createdPhoto = photoService.save(photoDto);
        return new ResponseEntity<>(createdPhoto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Photo>> getAll() {
        List<Photo> photos = photoService.findAll();
        return new ResponseEntity<>(photos, HttpStatus.OK);
    }

    @GetMapping("{id}/")
    public ResponseEntity<Photo> getById(@PathVariable int id) {
        return photoService.findById(id)
                .map(photo -> new ResponseEntity<>(photo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("{id}/")
    public ResponseEntity<Photo> update(@PathVariable int id, @RequestBody PhotoDto photoDto) {
        return photoService.update(id, photoDto)
                .map(updatedPhoto -> new ResponseEntity<>(updatedPhoto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}/")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        photoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
