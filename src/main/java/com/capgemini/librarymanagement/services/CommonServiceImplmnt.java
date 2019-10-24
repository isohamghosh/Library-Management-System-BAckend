package com.capgemini.librarymanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.librarymanagement.dao.CommonDAO;
import com.capgemini.librarymanagement.dto.BooksInventory;
import com.capgemini.librarymanagement.dto.Users;

public class CommonServiceImplmnt implements CommonService {
	@Autowired
	CommonDAO dao;

	@Override
	public Boolean login(String studentId, String password) {
		return null;
	}

	@Override
	public List<BooksInventory> getListOfBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> displayAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}

}
