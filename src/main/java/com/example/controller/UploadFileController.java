package com.example.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.model.Document;
import com.example.service.DocumentService;

@Controller
@RequestMapping("/upload")
public class UploadFileController {
	@Autowired
	private DocumentService documentService;
	// private static String UPLOAD_LOCATION = "D://Eclipse//SpringBootDemo//src//main//resources//static//images//";
	private static String UPLOAD_LOCATION = "D://Eclipse//SpringBootDemo//photos//";
	
	@GetMapping("/uploadpage")
	public ModelAndView viewUploadFilePage() {
		ModelAndView mv = new ModelAndView();
		List<Document> documents = documentService.getAllDocuments();
		mv.addObject("documents", documents);
		mv.setViewName("websites/upload/uploadpage");
		return mv;
	}
	
	@PostMapping("/upload_file")
	public String uploadFile(@RequestParam("files") MultipartFile file, RedirectAttributes redirect) {
		if (file.isEmpty()) {
			redirect.addFlashAttribute("message", "Please, select a file and try again!!");
			return "redirect:uploadpage";
		}
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOAD_LOCATION + file.getOriginalFilename());
			Files.write(path, bytes);
			redirect.addFlashAttribute("message", "You successfully uploaded: " + file.getOriginalFilename());
			System.out.println("======> " + "Files uploaded!!");
		} catch (Exception ex) {
			redirect.addFlashAttribute("message", ex.getMessage());
			System.out.println("======> " + ex.getMessage());
			return "redirect:upload_status";
		}
		return "redirect:upload_status";
	}
	
	@PostMapping("/upload_files")
	public String uploadMultiFiles(@RequestParam("multifiles") MultipartFile[] files, RedirectAttributes redirect) throws IOException {
		for (MultipartFile file : files) {
			if (file.isEmpty()) {
				redirect.addFlashAttribute("messages", "Please, select a file and try again!!");
				return "redirect:uploadpage";
			}
			documentService.saveDocument(file);
			redirect.addFlashAttribute("messages", "You successfully uploaded!!");
			System.out.println("======> " + "Multi files uploaded!!");
		}
		return "redirect:upload_status";
	}
	
	@GetMapping("/upload_status")
	public String viewUploadFileStatusPage() {
		return "websites/upload/upload_status";
	}
	
	@GetMapping("/downloadFile/{fileId}")
	public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable("fileId") Integer fileId) {
		Document document = documentService.getDocumentById(fileId).get();
		return ResponseEntity.ok()
			   .contentType(MediaType.parseMediaType(document.getDocType()))
			   .header(HttpHeaders.CONTENT_DISPOSITION, "attachment:filename=\"" + document.getDocName() + "\"")
			   .body(new ByteArrayResource(document.getDocData()));
	}
	
	@GetMapping("/deleteFile/{fileId}")
	public String deleteDocument(@PathVariable("fileId") Integer fileId) {
		documentService.deleteDocument(fileId);
		System.out.println("File deleted!!");
		return "websites/upload/success_delete";
	}
}
