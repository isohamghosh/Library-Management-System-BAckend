package com.capgemini.librarymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarymanagement.dto.BooksInventory;
import com.capgemini.librarymanagement.dto.BooksRegistration;
import com.capgemini.librarymanagement.dto.BooksTransaction;
import com.capgemini.librarymanagement.dto.UserResponse;
import com.capgemini.librarymanagement.dto.Users;
import com.capgemini.librarymanagement.exception.CustomException;
import com.capgemini.librarymanagement.services.LibrarianService;

@RestController
@RequestMapping("/librarian")
public class LibrarianController {
	@Autowired
	private LibrarianService service;
	
	@PostMapping("/addNewBook")
	public UserResponse addNewBook(@RequestBody BooksInventory booksInventory) {
		UserResponse response=new UserResponse();
		if(service.addNewBook(booksInventory) != null) {
			response.setStatusCode(201);
			response.setMessage("success");
		}else {
			response.setStatusCode(404);
			response.setMessage("failed");
		}return response;

	}//end of addNewBook
	
	@PostMapping("/updateBook")
	public UserResponse updateBook(@RequestBody BooksInventory booksInventory) {
		UserResponse response=new UserResponse();
		if(service.updateBook(booksInventory) != null) {
			response.setStatusCode(201);
			response.setMessage("success");
		}else {
			response.setStatusCode(404);
			response.setMessage("failed");
		}return response;
	}//end of updateBook
	
	@DeleteMapping("/deleteBook/{bookId}")
	public UserResponse deleteBook(@PathVariable(name="bookId") String bookId) {
		UserResponse response=new UserResponse();
		if(service.deleteBook(bookId)) {
			response.setStatusCode(201);
			response.setMessage("success");
		}else {
			response.setStatusCode(404);
			response.setMessage("failed");
		}return response;

	}//end of deleteBook
	
	@GetMapping("/getAllBookRequest")
	public List<BooksRegistration> getBookRequest() {
		return service.getBookRequest();
	}
	
	@PostMapping("/responseBookRequest/{id}")
	public BooksTransaction responseBookRequest(@PathVariable(name="id") Integer id) {
		return service.responseBookRequest(id);

	}
	
	@GetMapping("/cancelBookRequest/{id}")
	public boolean cancelBookRequest(@PathVariable(name="id") Integer id) {
		return service.cancelBookRequest(id);
	}
	
	@GetMapping("/searchStudent/{id}")
	public UserResponse searchStudent(@PathVariable(name="id") String id) {
		UserResponse response=new UserResponse();
		try {
		List<Users> student = service.searchStudent(id);
			if(student!=null) {
				response.setStatusCode(201);
				response.setMessage("success");
			}else {
				response.setStatusCode(404);
				response.setMessage("failed");
			}
		}catch (Exception e) {
			throw new CustomException("No such Student Found");
		}return response;

	}//end of searchStudents
		
	@DeleteMapping("/deleteStudent/{id}")
	public UserResponse deleteStudent(@PathVariable(name="id") String id) {
		UserResponse response=new UserResponse();
		if(service.deleteStudent(id)) {
			response.setStatusCode(201);
			response.setMessage("success");
		}else {
			response.setStatusCode(404);
			response.setMessage("failed");
		}return response;

	}//end of deleteStudent	

}
