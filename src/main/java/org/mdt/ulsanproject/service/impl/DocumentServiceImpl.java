package org.mdt.ulsanproject.service.impl;

import org.mdt.ulsanproject.dto.DocumentDto;
import org.mdt.ulsanproject.model.Document;
import org.mdt.ulsanproject.repository.DocumentRepository;
import org.mdt.ulsanproject.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public Document save(DocumentDto documentDto) {
        Document document = Document.builder()
                .title(documentDto.getTitle())
                .content(documentDto.getContent())
                .author_id(documentDto.getAuthor_id())
                .build();
        return documentRepository.save(document);
    }

    @Override
    public Document update(int id, DocumentDto documentDto) {

        return null;
    }

    @Override
    public List<Document> findAll() {
        return documentRepository.findAll();
    }

    @Override
    public Optional<Document> findById(int id) {
        return documentRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        documentRepository.deleteById(id);
    }

}
