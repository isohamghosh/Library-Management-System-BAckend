package com.capgemini.librarymanagement.dao;

import java.util.List;

import com.capgemini.librarymanagement.dto.BooksInventory;

public interface StudentDAO {
	
	//students operations
		public List<BooksInventory> searchForBook(String bookName);
		
		public BooksInventory makeBookRequest(BooksInventory booksInvent);
		public Boolean cancelRequestedBook(BooksInventory booksInvent);
		public Boolean getResponse(BooksInventory booksInvent);

}
