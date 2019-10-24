package com.capgemini.librarymanagement.dao;

import com.capgemini.librarymanagement.dto.BooksInventory;

public interface StudentDAO {
	
	//students operations
		public BooksInventory searchForBook(String bookId);
		public BooksInventory makeBookRequest(BooksInventory booksInvent);
		public Boolean cancelRequestedBook(BooksInventory booksInvent);
		public Boolean getResponse(BooksInventory booksInvent);

}
