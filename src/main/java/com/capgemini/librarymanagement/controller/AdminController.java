package com.capgemini.librarymanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarymanagement.dto.UserResponse;
import com.capgemini.librarymanagement.dto.Users;
import com.capgemini.librarymanagement.services.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService service;

	
	@PostMapping("/addLibrarian")
	public UserResponse  addLibrarian(@RequestBody Users librarian) {
		UserResponse response=new UserResponse();
		
		if(service.addLibrarian(librarian) != null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Librarian added Sucessfully");
		}else {
			response.setStatusCode(404);
			response.setMessage("failed");
			response.setDescription("Librarian not added");
		}return response;

	}//end of addLibrarian
	
	@PutMapping("/updateLibrarian")
	public UserResponse updateLibrarian(@RequestBody Users librarian) {
		UserResponse response=new UserResponse();
		if(service.updateLibrarian(librarian) != null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Librarian Updated Sucessfull");
		}else {
			response.setStatusCode(404);
			response.setMessage("failed");
			response.setDescription("Librarian not updated");
		}return response;
	}//end of updateLibrarian
	
	@GetMapping("/searchLibrarian/{id}")
	public UserResponse searchLibrarian(@PathVariable(name = "id")String librarianId) {
		UserResponse response=new UserResponse();
		try {
		Users librarians = service.searchLibrarian(librarianId);
			if(librarians!=null) {
				response.setStatusCode(201);
				response.setMessage("success");
				response.setLibrarians(librarians);
			}else {
				response.setStatusCode(404);
				response.setMessage("failed");
			}
		}catch (Exception e) {
			//System.out.println("");
		}return response;

	}//end of searchLibrarian
	
	@DeleteMapping("/deleteLibrarian/{id}")
	public UserResponse deleteLibrarian(@PathVariable(name="id")String librarianId) {
		UserResponse response=new UserResponse();
		if(service.deleteLibrarian(librarianId)) {
			response.setStatusCode(201);
			response.setMessage("success");
		}else {
			response.setStatusCode(404);
			response.setMessage("failed");
		}return response;

	}//end of deleteLibrarian

}
