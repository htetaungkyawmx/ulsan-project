package org.mdt.ulsanproject.controller;

import org.mdt.ulsanproject.dto.DocumentDto;
import org.mdt.ulsanproject.model.Document;
import org.mdt.ulsanproject.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/document")
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @PostMapping("/create")
    public ResponseEntity<Document> create(@RequestBody DocumentDto documentDto) {
        Document createDocument = documentService.save(documentDto);
        return new ResponseEntity<>(createDocument, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Document>> getAll() {
        List<Document> documents = documentService.findAll();
        return new ResponseEntity<>(documents, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Document> update(@PathVariable int id) {
        return documentService.findById(id)
                .map(document -> new ResponseEntity<>(document, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        documentService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
