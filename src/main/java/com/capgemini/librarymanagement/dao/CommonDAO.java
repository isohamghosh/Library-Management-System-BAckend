package com.capgemini.librarymanagement.dao;

import java.util.List;

import com.capgemini.librarymanagement.dto.BooksInventory;
import com.capgemini.librarymanagement.dto.Users;

public interface CommonDAO {
	
	//Login Users
		public Users login(Users user);
		
		public List<BooksInventory> getListOfBooks();
		public List<Users> displayAllStudents();


}
