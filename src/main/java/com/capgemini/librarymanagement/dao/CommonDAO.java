package com.capgemini.librarymanagement.dao;

import java.util.List;

import com.capgemini.librarymanagement.dto.BooksInventory;
import com.capgemini.librarymanagement.dto.Users;

public interface CommonDAO {
	
	//Login Users
		public Boolean login(String studentId, String password);
		
		public List<BooksInventory> getListOfBooks();
		public List<Users> displayAllStudents();


}
