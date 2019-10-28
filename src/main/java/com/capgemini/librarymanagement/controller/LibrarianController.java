package com.capgemini.librarymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarymanagement.dto.BooksInventory;
import com.capgemini.librarymanagement.dto.BooksRegistration;
import com.capgemini.librarymanagement.dto.BooksTransaction;
import com.capgemini.librarymanagement.dto.Users;
import com.capgemini.librarymanagement.services.LibrarianService;

@CrossOrigin(origins = "*", allowedHeaders = "*",allowCredentials = "true")
@RestController
@RequestMapping("/librarian")
public class LibrarianController {
	@Autowired
	private LibrarianService service;

	@PostMapping("/addNewBook")
	public BooksInventory addNewBook(@RequestBody BooksInventory booksInventory) {
		return service.addNewBook(booksInventory);
	}// end of addNewBook

	@PutMapping("/updateBook")
	public BooksInventory updateBook(@RequestBody BooksInventory booksInventory) {
		return service.updateBook(booksInventory);
	}// end of updateBook

	@DeleteMapping("/deleteBook/{bookId}")
	public boolean deleteBook(@PathVariable(name = "bookId") String bookId) {
		return service.deleteBook(bookId);
	}// end of deleteBook

	@GetMapping("/getAllBookRequest")
	public List<BooksRegistration> getBookRequest() {
		return service.getBookRequest();
	}// end of getBookRequest

	@GetMapping("/responseBookRequest/{id}")
	public BooksTransaction responseBookRequest(@PathVariable(name = "id") Integer id) {
		return service.responseBookRequest(id);
	}// end of responseBookRequest

	@GetMapping("/cancelBookRequest/{id}")
	public boolean cancelBookRequest(@PathVariable(name = "id") Integer id) {
		return service.cancelBookRequest(id);
	}// end of cancelBookRequest

	@PostMapping("/addStudent")
	public Users addNewStudent(@RequestBody Users student) {
		return service.addNewStudent(student);
	}// end of addNewStudent

	@DeleteMapping("/deleteStudent/{id}")
	public boolean deleteLibrarian(@PathVariable(name = "id") String studentId) {
		return service.deleteStudent(studentId);
	}// end of deleteLibrarian
	
	@GetMapping("/searchStudent")
	public List<Users> searchStudent() {
		return service.searchStudent();
	}// end of deleteStudent
	
	@PutMapping("/updateStudent")
	public Users updateLibrarian(@RequestBody Users student) {
		return service.updateStudent(student);
	}// end of updateStudent
	
	@GetMapping("/searchBooks")
	public List<BooksInventory> searchBooks() {
		return service.searchBook();
	}// end of deleteStudent
}
