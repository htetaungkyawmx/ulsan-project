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
                .authorId(documentDto.getAuthor_id())
                .summary(documentDto.getSummary())
                .tags(documentDto.getTags())
                .category(documentDto.getCategory())
                .documentType(documentDto.getDocumentType())
                .visibility(documentDto.isVisibility())
                .filePath(documentDto.getFilePath())
                .thumbnailPath(documentDto.getThumbnailPath())
                .build();
        return documentRepository.save(document);
    }

    @Override
    public Optional<Document> update(int id, DocumentDto documentDto) {
        return documentRepository.findById(id).map(existingDocument -> {
            existingDocument.setTitle(documentDto.getTitle());
            existingDocument.setContent(documentDto.getContent());
            existingDocument.setAuthorId(documentDto.getAuthor_id());
            existingDocument.setSummary(documentDto.getSummary());
            existingDocument.setTags(documentDto.getTags());
            existingDocument.setCategory(documentDto.getCategory());
            existingDocument.setDocumentType(documentDto.getDocumentType());
            existingDocument.setVisibility(documentDto.isVisibility());
            existingDocument.setFilePath(documentDto.getFilePath());
            existingDocument.setThumbnailPath(documentDto.getThumbnailPath());
            return documentRepository.save(existingDocument);
        });
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
