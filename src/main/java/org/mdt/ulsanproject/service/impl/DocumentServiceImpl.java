package org.mdt.ulsanproject.service.impl;

import org.mdt.ulsanproject.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentServiceImpl {
    @Autowired
    private DocumentRepository documentRepository;

}
