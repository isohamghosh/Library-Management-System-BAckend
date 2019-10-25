package com.capgemini.librarymanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagement.dao.LibrarianDAO;
import com.capgemini.librarymanagement.dto.BooksInventory;
import com.capgemini.librarymanagement.dto.Users;

@Service
public class LibrarianServiceImplmnt implements LibrarianService {
	
	@Autowired
	private LibrarianDAO dao;

	@Override
	public BooksInventory addNewBook(BooksInventory booksInvent) {
		return dao.addNewBook(booksInvent);
	}

	@Override
	public BooksInventory updateBook(BooksInventory booksInvent) {
		return dao.updateBook(booksInvent);
	}

	@Override
	public Boolean deleteBook(String bookId) {
		return dao.deleteBook(bookId);
	}

	@Override
	public BooksInventory getBookRequest(BooksInventory booksInvent) {
		return dao.getBookRequest(booksInvent);
	}

	@Override
	public Boolean cancelBookRequest(String bookId, String bookName) {
		return dao.cancelBookRequest(bookId, bookName);
	}

	@Override
	public List<Users> searchStudent(String studentId) {
		return dao.searchStudent(studentId);
	}

	@Override
	public Boolean deleteStudent(String studentId) {
		return dao.deleteStudent(studentId);
	}

}
