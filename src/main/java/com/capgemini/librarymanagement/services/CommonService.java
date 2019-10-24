package com.capgemini.librarymanagement.services;

import java.util.List;

import com.capgemini.librarymanagement.dto.BooksInventory;
import com.capgemini.librarymanagement.dto.Users;

public interface CommonService {

	//Login Users
	public Users login(String studentId, String password);
	
	public List<BooksInventory> getListOfBooks();
	public List<Users> displayAllStudents();

}
