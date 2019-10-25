package com.capgemini.librarymanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagement.dao.StudentDAO;
import com.capgemini.librarymanagement.dto.BooksInventory;

@Service
public class StudentServiceImplmnt implements StudentService {
	
	@Autowired
	private StudentDAO dao;

	@Override
	public List<BooksInventory> searchForBook(String bookName) {
		return dao.searchForBook(bookName);
	}

	@Override
	public BooksInventory makeBookRequest(BooksInventory booksInvent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean cancelRequestedBook(BooksInventory booksInvent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean getResponse(BooksInventory booksInvent) {
		// TODO Auto-generated method stub
		return null;
	}

}
