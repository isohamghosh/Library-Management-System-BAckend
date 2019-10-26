package com.capgemini.librarymanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagement.dao.StudentDAO;
import com.capgemini.librarymanagement.dto.BooksInventory;
import com.capgemini.librarymanagement.dto.BooksRegistration;
import com.capgemini.librarymanagement.dto.BooksTransaction;

@Service
public class StudentServiceImplmnt implements StudentService {
	
	@Autowired
	private StudentDAO dao;

	@Override
	public List<BooksInventory> searchForBook(String bookName) {
		return dao.searchForBook(bookName);
	}

	@Override
	public BooksRegistration makeBookRequest(String bookId) {
		return dao.makeBookRequest(bookId);
	}

	@Override
	public Boolean cancelRequestedBook(Integer registrationId) {
		return dao.cancelRequestedBook(registrationId);
	}

	@Override
	public List<BooksTransaction> getResponse() {
		return dao.getResponse();
	}

	@Override
	public List<BooksRegistration> getAllRequestedBook() {
		return dao.getAllRequestedBook();
	}

	@Override
	public boolean returnBook(Integer transectionId) {
		return dao.returnBook(transectionId);
	}

}
