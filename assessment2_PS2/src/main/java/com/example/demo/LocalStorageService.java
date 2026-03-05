<<<<<<< HEAD
package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("localStorage")
@Scope("prototype")
public class LocalStorageService implements StorageService{
	public LocalStorageService() {
		System.out.println("LocalStorageService Bean Created");
	}
	
	@Override
	public void storeFile(String fileName) {
		System.out.println("File Stored in Local Storage: " + fileName);
	}
}
=======
package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("localStorage")
@Scope("prototype")
public class LocalStorageService implements StorageService{
	public LocalStorageService() {
		System.out.println("LocalStorageService Bean Created");
	}
	
	@Override
	public void storeFile(String fileName) {
		System.out.println("File Stored in Local Storage: " + fileName);
	}
}
>>>>>>> 2c042f7599e924ec48b4b59faf444e2b50e3b068
