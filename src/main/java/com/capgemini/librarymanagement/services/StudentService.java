package com.capgemini.librarymanagement.services;

import java.util.List;

import com.capgemini.librarymanagement.dto.BooksInventory;

public interface StudentService {
	
	
	//students operations
	public List<BooksInventory> searchForBook(String bookName);
	public BooksInventory makeBookRequest(BooksInventory booksInvent);
	public Boolean cancelRequestedBook(BooksInventory booksInvent);
	public Boolean getResponse(BooksInventory booksInvent);

}
