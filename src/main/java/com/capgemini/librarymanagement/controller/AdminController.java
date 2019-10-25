package com.capgemini.librarymanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarymanagement.dto.Users;
import com.capgemini.librarymanagement.services.AdminService;

@RestController 
@CrossOrigin(origins = "*", allowedHeaders  = "*" , allowCredentials = "true")
public class AdminController {
	@Autowired
	AdminService service ;
	
	@PostMapping("add/librarian")
	public  Users addLibrarian(@RequestBody Users librarian) {
		Users  librarian1 = service.addLibrarian(librarian);
		return librarian1;
			
	}
	
	@DeleteMapping("delete/librarian/{librarianId}")
	public Users deleteLibrarian(@PathVariable("librarianId")String librarianId) {
		Users users = null;
			users=service.deleteLibrarian(librarianId);
		    return users;
		
	}
	

}
