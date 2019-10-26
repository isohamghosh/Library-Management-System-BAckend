package com.capgemini.librarymanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarymanagement.dto.Users;
import com.capgemini.librarymanagement.services.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService service;

	@PostMapping("/addLibrarian")
	public Users addLibrarian(@RequestBody Users librarian) {
		return service.addLibrarian(librarian);
	}// end of addLibrarian

	@PutMapping("/updateLibrarian")
	public Users updateLibrarian(@RequestBody Users librarian) {
		return service.updateLibrarian(librarian);
	}// end of updateLibrarian

	@GetMapping("/searchLibrarian/{id}")
	public Users searchLibrarian(@PathVariable(name = "id") String librarianId) {
		return service.searchLibrarian(librarianId);
	}// end of searchLibrarian

	@DeleteMapping("/deleteLibrarian/{id}")
	public boolean deleteLibrarian(@PathVariable(name = "id") String librarianId) {
		return service.deleteLibrarian(librarianId);
	}// end of deleteLibrarian

}
