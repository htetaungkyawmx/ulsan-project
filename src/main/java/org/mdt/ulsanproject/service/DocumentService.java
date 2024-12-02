package org.mdt.ulsanproject.service;

import org.mdt.ulsanproject.dto.DocumentDto;
import org.mdt.ulsanproject.model.Document;

import java.util.List;

public interface DocumentService {
    Document save(DocumentDto documentDto);
    Document update(int id, DocumentDto documentDto);
    List<Document> findAll();
    void delete(int id);
}
