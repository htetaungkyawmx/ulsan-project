package org.mdt.ulsanproject.controller;

import org.mdt.ulsanproject.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumentController {
    @Autowired
    private DocumentService documentService;

}
