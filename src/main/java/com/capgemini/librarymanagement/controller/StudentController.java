package com.capgemini.librarymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarymanagement.dto.BooksInventory;
import com.capgemini.librarymanagement.dto.UserResponse;
import com.capgemini.librarymanagement.services.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService service;
	
	@GetMapping("/searchBook/{bookName}")
	@ResponseBody
	public List<BooksInventory> SearchForBook(@PathVariable("bookName") String bookName) {
		List<BooksInventory> bookInventory = null;
		bookInventory = service.searchForBook(bookName);
		return bookInventory;
	}//end of searchForBooks

}
