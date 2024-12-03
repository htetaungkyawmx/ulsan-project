package org.mdt.ulsanproject.controller;

import org.mdt.ulsanproject.dto.FeedBackDto;
import org.mdt.ulsanproject.model.FeedBack;
import org.mdt.ulsanproject.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedBackController {
    @Autowired
    private FeedBackService feedBackService;

    @PostMapping("/create")
    public ResponseEntity<FeedBack> create(@RequestBody FeedBackDto feedBackDto) {
        FeedBack createdFeedBack = feedBackService.save(feedBackDto);
        return new ResponseEntity<>(createdFeedBack, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<FeedBack>> getAll() {
        List<FeedBack> feedBacks = feedBackService.findAll();
        return new ResponseEntity<>(feedBacks, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FeedBack> update(@PathVariable int id) {
        return feedBackService.findById(id)
                .map(feedBack -> new ResponseEntity<>(feedBack, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        feedBackService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}