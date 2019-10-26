package com.capgemini.librarymanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagement.dao.LibrarianDAO;
import com.capgemini.librarymanagement.dto.BooksInventory;
import com.capgemini.librarymanagement.dto.BooksRegistration;
import com.capgemini.librarymanagement.dto.BooksTransaction;
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
	public List<BooksRegistration> getBookRequest(){
		return dao.getBookRequest();
	}

	@Override
	public Boolean cancelBookRequest(Integer registrationId) {
		return dao.cancelBookRequest(registrationId);
	}

	@Override
	public List<Users> searchStudent(String studentId) {
		return dao.searchStudent(studentId);
	}

	@Override
	public Boolean deleteStudent(String studentId) {
		return dao.deleteStudent(studentId);
	}

	@Override
	public BooksTransaction responseBookRequest(Integer registrationId) {
		return dao.responseBookRequest(registrationId);
	}

}
