package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	public BookService bookService;
	
	@PostMapping
	public ResponseEntity<Book> addBook(@RequestBody Book book){
		Book books = bookService.addBook(book);
		return new ResponseEntity<>(books,HttpStatus.CREATED);
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<Book> updateBookById(@PathVariable Long id,@RequestBody Book book){
		Book books = bookService.updateBookById(id,book);
		return ResponseEntity.ok(books);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteBookById(@PathVariable Long id){
		bookService.deleteBookById(id);
		return ResponseEntity.ok("Book Deleted Successfully");
	}
	
	@GetMapping
	public ResponseEntity<List<Book>> getAllBooks(){
		List<Book> books = bookService.getAllBooks();
		return ResponseEntity.ok(books);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable Long id){
		Book books = bookService.getBookById(id);
		return ResponseEntity.ok(books);
	}
}