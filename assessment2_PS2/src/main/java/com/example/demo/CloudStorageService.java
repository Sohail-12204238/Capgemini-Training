package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("cloudStorage")
@Primary
public class CloudStorageService implements StorageService{
	public CloudStorageService() {
		System.out.println("CloudStorageService Bean Created");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Cloud Storage has been initialized");
	}
	
	@Override
	public void storeFile(String fileName) {
		System.out.println("File Stored in cloud Storage: " + fileName);
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Cloud Storage Bean has been destroyed");
	}
	
}
