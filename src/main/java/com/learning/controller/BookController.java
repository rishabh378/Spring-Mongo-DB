package com.learning.controller;

import com.learning.document.Book;
import com.learning.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {

	private final BookService bookService;
	
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable("id") int id) {
		return bookService.getBookById(id);
	}

	@GetMapping
	public List<Book> getAllBook() {
		return bookService.getAllBook();
	}

	@PostMapping
	public String saveBook(@RequestBody Book book) {
		bookService.saveBook(book);
		return "Added book with id: " + book.getId();
	}
	
	@PutMapping("/{id}")
	public String updateBook(@PathVariable("id") int id, @RequestBody Book book) {
		boolean idExist = bookService.updateBook(id, book);
		if (idExist) {
			return "Updated book with id:" + id;
		}
		return "id not found";
	}
	
	@DeleteMapping("/{id}")
	public String deleteBookById(@PathVariable("id") int id) {
		bookService.deleteBookById(id);
		return "delete book with id:" + id;
	}
}
