package com.capgemini.librarymanagement.services;

import com.capgemini.librarymanagement.dto.BooksInventory;

public interface StudentService {
	
	
	//students operations
	public BooksInventory searchForBook(String bookId);
	public BooksInventory makeBookRequest(BooksInventory booksInvent);
	public Boolean cancelRequestedBook(BooksInventory booksInvent);
	public Boolean getResponse(BooksInventory booksInvent);

}
