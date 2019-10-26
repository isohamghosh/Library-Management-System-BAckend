package com.capgemini.librarymanagement.services;

import java.util.List;

import com.capgemini.librarymanagement.dto.BooksInventory;
import com.capgemini.librarymanagement.dto.BooksRegistration;
import com.capgemini.librarymanagement.dto.BooksTransaction;

public interface StudentService {
	
	
	//students operations
	public List<BooksInventory> searchForBook(String bookName);
	public BooksRegistration makeBookRequest(String bookId);
	public Boolean cancelRequestedBook(Integer registrationId);
	public List<BooksTransaction> getResponse();
	public List<BooksRegistration> getAllRequestedBook();
	public boolean returnBook(Integer transectionId);
}
