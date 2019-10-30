package com.capgemini.librarymanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagement.dao.LibrarianDAO;
import com.capgemini.librarymanagement.dto.BooksInventory;
import com.capgemini.librarymanagement.dto.BooksRegistration;
import com.capgemini.librarymanagement.dto.BooksTransaction;
import com.capgemini.librarymanagement.dto.Users;
import com.capgemini.librarymanagement.validations.BackendValidation;

@Service
public class LibrarianServiceImplmnt implements LibrarianService {

	@Autowired
	private LibrarianDAO dao;

	private BackendValidation validate = new BackendValidation();

	@Override
	public BooksInventory addNewBook(BooksInventory booksInvent) {
		validate.validateyearOfPublication(booksInvent.getYearOfPublication());
		return dao.addNewBook(booksInvent);
	}

	@Override
	public BooksInventory updateBook(BooksInventory booksInvent) {
		validate.validateyearOfPublication(booksInvent.getYearOfPublication());
		return dao.updateBook(booksInvent);
	}

	@Override
	public Boolean deleteBook(String bookId) {
		return dao.deleteBook(bookId);
	}

	@Override
	public List<BooksRegistration> getBookRequest() {
		return dao.getBookRequest();
	}

	@Override
	public Boolean cancelBookRequest(Integer registrationId) {
		return dao.cancelBookRequest(registrationId);
	}

	@Override
	public Users addNewStudent(Users student) {
		validate.validateId(student.getId());
		validate.validateEmailId(student.getEmailId());
		return dao.addNewStudent(student);
	}

	@Override
	public List<Users> searchStudent() {
		return dao.searchStudent();
	}

	@Override
	public Boolean deleteStudent(String studentId) {
		return dao.deleteStudent(studentId);
	}

	@Override
	public BooksTransaction responseBookRequest(Integer registrationId) {
		return dao.responseBookRequest(registrationId);
	}
	
	@Override
	public Users updateStudent(Users student) {
		if(validate.validateId(student.getId()) && validate.validateEmailId(student.getEmailId())) {
			return dao.updateStudent(student);
		} else {
			return null;
		}
	}
	
	public List<BooksInventory> searchBook() {
		return dao.searchBook();
	}

}
