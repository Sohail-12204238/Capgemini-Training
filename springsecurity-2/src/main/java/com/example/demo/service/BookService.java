package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	public BookRepository bookRepository;

	public Book addBook(Book book) {
		return bookRepository.save(book);
	}
	
	public Book updateBookById(Long id,Book book) {
		Book books = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("No Book Found"));
		books.setTitle(book.getTitle());
		books.setAuthor(book.getAuthor());
		books.setPrice(book.getPrice());
		books.setCategory(book.getCategory());
		
		return bookRepository.save(books);
	}
	
	public void deleteBookById(Long id) {
		Book books = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book Not Found"));
		bookRepository.delete(books);
	}
	
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	
	public Book getBookById(Long id) {
		Book books = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book Not Found"));
		return books;
	}
}
