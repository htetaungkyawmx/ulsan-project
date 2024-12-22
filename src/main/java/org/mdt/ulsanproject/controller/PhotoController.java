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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/photo")
public class PhotoController {
    private static final String UPLOAD_DIR = "public/uploads";

    @Autowired
    private PhotoService photoService;

    @PostMapping
    public ResponseEntity<Photo> create(
            @Validated @RequestPart("photo") PhotoDto photoDto,
            @RequestPart("file") MultipartFile file) throws IOException {

        // Save file
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path path = Paths.get(UPLOAD_DIR, fileName);
        Files.createDirectories(path.getParent());
        Files.write(path, file.getBytes());

        // Set file URL
        photoDto.setUrl(path.toString());

        Photo createdPhoto = photoService.save(photoDto);
        return new ResponseEntity<>(createdPhoto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<Photo>> getAll(@RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "10") int size) {
        Page<Photo> photos = photoService.findAll(PageRequest.of(page, size));
        return new ResponseEntity<>(photos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Photo> getById(@PathVariable int id) {
        return photoService.findById(id)
                .map(photo -> new ResponseEntity<>(photo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Photo> update(@PathVariable int id, @Validated @RequestBody PhotoDto photoDto) {
        return photoService.update(id, photoDto)
                .map(updatedPhoto -> new ResponseEntity<>(updatedPhoto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        photoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
