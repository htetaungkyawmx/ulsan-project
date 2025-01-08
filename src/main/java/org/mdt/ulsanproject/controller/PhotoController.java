package org.mdt.ulsanproject.controller;

import org.mdt.ulsanproject.dto.PhotoDto;
import org.mdt.ulsanproject.model.Photo;
import org.mdt.ulsanproject.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/api/photo")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    // Create a new photo
    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Photo> create(
            @Validated @RequestPart("photo") PhotoDto photoDto,
            @RequestPart("file") MultipartFile file) throws IOException {

        // Check if the file is empty
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null);  // Return a bad request if the file is empty
        }

        byte[] fileData = file.getBytes();
        Photo createdPhoto = photoService.save(photoDto, fileData);
        return new ResponseEntity<>(createdPhoto, HttpStatus.CREATED);
    }

    // Get all photos with pagination
    @GetMapping
    public ResponseEntity<Page<Photo>> getAll(@RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "10") int size) {
        Page<Photo> photos = photoService.findAll(PageRequest.of(page, size));
        return new ResponseEntity<>(photos, HttpStatus.OK);
    }

    // Get a photo by ID
    @GetMapping("/{id}")
    public ResponseEntity<Photo> getById(@PathVariable int id) {
        Optional<Photo> photo = photoService.findById(id);
        return photo.map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update an existing photo
    @PutMapping("/{id}")
    public ResponseEntity<Photo> update(
            @PathVariable int id,
            @Validated @RequestPart("photo") PhotoDto photoDto,
            @RequestPart("file") MultipartFile file) throws IOException {

        // Check if the file is empty
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null);  // Return bad request if no file is provided
        }

        byte[] fileData = file.getBytes();
        Optional<Photo> updatedPhoto = photoService.update(id, photoDto, fileData);

        return updatedPhoto.map(photo -> new ResponseEntity<>(photo, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Delete a photo by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        photoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
