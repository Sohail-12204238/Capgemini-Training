package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Assessment2Ps2Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Assessment2Ps2Application.class, args);
		StorageService defaultStorageServie = context.getBean(StorageService.class);
		StorageService cloudStorageService = (StorageService) context.getBean("cloudStorage");
		StorageService localStorageService1 = (StorageService) context.getBean("localStorage");
		StorageService localStorageService2 = (StorageService) context.getBean("localStorage");

		cloudStorageService.storeFile("file1.txt");
		localStorageService1.storeFile("file2.txt");
		localStorageService2.storeFile("file3.txt");
		defaultStorageServie.storeFile("file4.txt");
		
		((ConfigurableApplicationContext) context).close();
		
	}

}
