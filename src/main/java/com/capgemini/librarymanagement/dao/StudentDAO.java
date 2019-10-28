package com.capgemini.librarymanagement.dao;

import java.util.List;

import com.capgemini.librarymanagement.dto.BooksInventory;
import com.capgemini.librarymanagement.dto.BooksRegistration;
import com.capgemini.librarymanagement.dto.BooksTransaction;

public interface StudentDAO {

	// students operations
	public List<BooksInventory> searchForBook(String bookName);

	public BooksRegistration makeBookRequest(String bookId);

	public List<BooksRegistration> getAllRequestedBook();

	public Boolean cancelRequestedBook(Integer registrationId);

	public List<BooksTransaction> getResponse();

	public int returnBook(Integer transectionId);

}
