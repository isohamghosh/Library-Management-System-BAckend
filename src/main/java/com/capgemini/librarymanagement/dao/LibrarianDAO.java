package com.capgemini.librarymanagement.dao;

import java.util.List;

import com.capgemini.librarymanagement.dto.BooksInventory;
import com.capgemini.librarymanagement.dto.Users;

public interface LibrarianDAO {
	
	//librarian operations
		public BooksInventory addNewBook(BooksInventory booksInvent);
		public BooksInventory updateBook(BooksInventory booksInvent);
		public Boolean deleteBook(String bookId);
		
		public BooksInventory getBookRequest(BooksInventory booksInvent);
		public Boolean cancelBookRequest(String bookId, String bookName);
		
		public List<Users> searchStudent(String studentId);
		public Boolean deleteStudent(String studentId);

}
