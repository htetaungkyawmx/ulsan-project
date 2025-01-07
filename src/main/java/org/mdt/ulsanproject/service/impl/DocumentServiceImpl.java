package org.mdt.ulsanproject.service.impl;

import org.mdt.ulsanproject.dto.DocumentDto;
import org.mdt.ulsanproject.dto.DocumentStatus;
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
                .authorId(documentDto.getAuthorId())
                .summary(documentDto.getSummary())
                .tags(String.join(",", documentDto.getTags())) // Convert list to comma-separated string
                .category(documentDto.getCategory())
                .documentType(documentDto.getDocumentType())
                .visibility(documentDto.isVisibility())
                .filePath(documentDto.getFilePath())
                .thumbnailPath(documentDto.getThumbnailPath())
                .status(DocumentStatus.DRAFT)
                .viewsCount(0)
                .likesCount(0)
                .downloadsCount(0)
                .build();
        return documentRepository.save(document);
    }

    @Override
    public Optional<Document> update(int id, DocumentDto documentDto) {
        return documentRepository.findById(id).map(existingDocument -> {
            existingDocument.setTitle(documentDto.getTitle());
            existingDocument.setContent(documentDto.getContent());
            existingDocument.setAuthorId(documentDto.getAuthorId());
            existingDocument.setSummary(documentDto.getSummary());
            existingDocument.setTags(String.join(",", documentDto.getTags())); // Convert list to string
            existingDocument.setCategory(documentDto.getCategory());
            existingDocument.setDocumentType(documentDto.getDocumentType());
            existingDocument.setVisibility(documentDto.isVisibility());
            existingDocument.setFilePath(documentDto.getFilePath());
            existingDocument.setThumbnailPath(documentDto.getThumbnailPath());
            return documentRepository.save(existingDocument);
        });
    }

    @Override
    public Optional<Document> incrementViews(int id) {
        return documentRepository.findById(id).map(existingDocument -> {
            existingDocument.setViewsCount(existingDocument.getViewsCount() + 1);
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
