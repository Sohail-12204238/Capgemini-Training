package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/add")
	public ResponseEntity<String> addProduct(
			@RequestParam String name,
			@RequestParam double price,
			@RequestParam MultipartFile image){
		String message = productService.addProduct(name, price, image);
		return ResponseEntity.ok(message);
	}
	
	@GetMapping("/image/{imageName}")
	public ResponseEntity<Resource> downloadImage(@PathVariable String imageName){
		Resource resource = productService.downloadImage(imageName);
		
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_OCTET_STREAM)
				.body(resource);
	}
}
