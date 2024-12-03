package org.mdt.ulsanproject.controller;

import org.mdt.ulsanproject.dto.VideoDto;
import org.mdt.ulsanproject.model.Video;
import org.mdt.ulsanproject.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/video")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @PostMapping("/create")
    public ResponseEntity<Video> create(@RequestBody VideoDto videoDto) {
        Video createdVideo = videoService.save(videoDto);
        return new ResponseEntity<>(createdVideo, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Video>> getAll() {
        List<Video> videos = videoService.findAll();
        return new ResponseEntity<>(videos, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Video> update(@PathVariable int id) {
        return videoService.findById(id)
                .map(video -> new ResponseEntity<>(video, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        videoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}