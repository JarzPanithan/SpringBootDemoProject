package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.DocumentService;

import com.example.model.Document;

@RestController
public class UploadFileRestController {
	@Autowired
	private DocumentService documentService;
	
	@PostMapping("/files")
	public List<Document> allFiles() {
		List<Document> documents = documentService.getAllDocuments();
		System.out.println("Files size: " + documents.size());
		return documents;
	}
}
