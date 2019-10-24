package com.capgemini.librarymanagement.dao;

import com.capgemini.librarymanagement.dto.BooksInventory;
import com.capgemini.librarymanagement.dto.Users;

public interface LibrarianDAO {
	
	//librarian operations
		public Boolean addNewBook(BooksInventory booksInvent);
		public Boolean updateBook(BooksInventory booksInvent);
		public Boolean deleteBook(String bookId);
		public BooksInventory getBookRequest(BooksInventory booksInvent);
		public Boolean cancelBookRequest(String bookId, String bookName);
		public Users searchStudent(String studentId);
		public Boolean deleteStudent(String studentId);

}
