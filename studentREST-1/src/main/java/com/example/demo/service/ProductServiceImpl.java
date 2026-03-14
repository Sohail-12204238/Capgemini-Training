package com.example.demo.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;



@Service
public class ProductServiceImpl implements ProductService{
	private final String UPLOAD_DIR = "uploads/";
	
	@Autowired
	public ProductRepository productRepository;
	
	@Override
	public String addProduct(String name,double price,MultipartFile image) {
		try {
			Path path = Paths.get(UPLOAD_DIR);
			if(!Files.exists(path)) {
				Files.createDirectories(path);
			}
			
			String imageName = image.getOriginalFilename();
			Path filePath = path.resolve(imageName);
			
			Files.copy(image.getInputStream(),filePath,StandardCopyOption.REPLACE_EXISTING);
			
			Product product = new Product();
			product.setName(name);
			product.setPrice(price);
			product.setImageName(imageName);
			
			productRepository.save(product);
			
			return "Product Added Successfully";
			
		}catch(IOException e) {
			throw new RuntimeException("Error uploading image");
		}
	}
	
	@Override
	public Resource downloadImage(String imageName) {
		try {
			Path filePath = Paths.get(UPLOAD_DIR).resolve(imageName);
			Resource resource = new UrlResource(filePath.toUri());
			
			if(resource.exists()) {
				return resource;
			}else {
				throw new RuntimeException("Image Not Found!");
			}
		}catch(Exception e) {
			throw new RuntimeException("Image Not Found!");		}
	}
	
}