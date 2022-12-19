package com.learning.service;

import com.learning.document.Book;
import com.learning.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public Book getBookById(int id) {
		return bookRepository.findById(id).get();
	}

	public List<Book> getAllBook() {
		List<Book> books = new ArrayList<>();
		bookRepository.findAll().forEach(books :: add);
		return books;
	}

	public void saveBook(Book book) {
		bookRepository.save(book);
	}
	
	public boolean updateBook(int id, Book book) {
		boolean idExist = false;
		if (bookRepository.existsById(id)) {
			idExist = true;
			bookRepository.save(book);
			return idExist;
		}
		return idExist;
	}
	
	public void deleteBookById(int id) {
		bookRepository.deleteById(id);
	}
	
	
}
