package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.model.Document;
import com.example.repository.DocumentRepository;

@Service
public class DocumentService {
	@Autowired
	private DocumentRepository documentRepository;
	
	public List<Document> getAllDocuments() {
		return documentRepository.findAll();
	}
	
	public Optional<Document> getDocumentById(Integer fileId) {
		return documentRepository.findById(fileId);
	}
	
	public Document saveDocument(MultipartFile file) {
		String docName = file.getOriginalFilename();
		try {
			Document newDocument = new Document();
			newDocument.setDocName(docName);
			newDocument.setDocType(file.getContentType());
			newDocument.setDocData(file.getBytes());
			return documentRepository.save(newDocument);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public Optional<Document> deleteDocument(Integer fileId) {
		documentRepository.deleteById(fileId);
		return null;
	}
}
