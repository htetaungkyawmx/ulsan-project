package org.mdt.ulsanproject.service;

import org.mdt.ulsanproject.dto.DocumentDto;
import org.mdt.ulsanproject.model.Document;

import java.util.List;
import java.util.Optional;

public interface DocumentService {

    Document save(DocumentDto documentDto);

    Optional<Document> update(int id, DocumentDto documentDto);

    List<Document> findAll();

    Optional<Document> findById(int id);

    void delete(int id);
}
