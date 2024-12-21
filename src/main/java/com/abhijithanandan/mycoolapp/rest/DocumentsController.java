package com.abhijithanandan.mycoolapp.rest;

import com.abhijithanandan.mycoolapp.services.DocumentsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class DocumentsController {

    private final DocumentsService documentsService;

    public DocumentsController(DocumentsService documentsService) {
        this.documentsService = documentsService;
    }

    private String sanitizeFileName(String fileName) {
        return fileName.replaceAll("[^a-zA-Z0-9._-]", "_");
    }

    private Path getSafePath(String userInputPath) throws IOException {
        try {
            Path path = Paths.get(userInputPath).normalize();
            if (!path.isAbsolute() && path.startsWith("..")) {
                throw new IOException("Invalid file path: path traversal attempt detected");
            }
            return path.toAbsolutePath();
        } catch (InvalidPathException e) {
            throw new IOException("Invalid file path", e);
        }
    }

    @GetMapping("/documents/{theDocument}")
    public String downloadDocuments(@PathVariable String theDocument) throws IOException {
        String key = "myKey";
        String sanitizedKey = sanitizeFileName(key);
        Path safePath = getSafePath(theDocument);
        documentsService.uploadFile(theDocument, sanitizedKey, safePath);


        return "Documents processed";
    }

}
