package org.mdt.ulsanproject.service.impl;

import org.mdt.ulsanproject.dto.DocumentDto;
import org.mdt.ulsanproject.model.Document;
import org.mdt.ulsanproject.repository.DocumentRepository;
import org.mdt.ulsanproject.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public Document save(DocumentDto documentDto) {
        return null;
    }

    @Override
    public Document update(int id, DocumentDto documentDto) {
        return null;
    }

    @Override
    public List<Document> findAll() {
        return List.of();
    }

    @Override
    public void delete(int id) {

    }

}
