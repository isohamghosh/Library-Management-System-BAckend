package com.capgemini.librarymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarymanagement.dto.BooksInventory;
import com.capgemini.librarymanagement.dto.BooksRegistration;
import com.capgemini.librarymanagement.dto.BooksTransaction;
import com.capgemini.librarymanagement.services.StudentService;

@CrossOrigin(origins = "*", allowedHeaders = "*",allowCredentials = "true")
@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService service;

	@GetMapping("/searchBook/{bookName}")
	public List<BooksInventory> searchForBook(@PathVariable("bookName") String bookName) {
		return service.searchForBook(bookName);
	}// end of searchForBooks

	@GetMapping("/makeBookRequest/{id}")
	public BooksRegistration makeBookRequest(@PathVariable(name = "id") String bookId) {
		return service.makeBookRequest(bookId);
	}// end of makeBookRequest

	@GetMapping("/getAllRequestedBook")
	public List<BooksRegistration> getAllRequestedBook() {
		return service.getAllRequestedBook();
	}// end of makeBookRequest

	@GetMapping("/getAllAllocatedBook")
	public List<BooksTransaction> getAllResponseBook() {
		return service.getResponse();
	}

	@GetMapping("/cancelRequest/{id}")
	public boolean cancelBookRequest(@PathVariable(name = "id") Integer id) {
		return service.cancelRequestedBook(id);
	}

	@GetMapping("/returnBook/{id}")
	public int returnBook(@PathVariable(name = "id") Integer id) {
		return service.returnBook(id);
	}
}
