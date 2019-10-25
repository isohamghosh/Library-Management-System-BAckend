package com.capgemini.librarymanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagement.dao.AdminDAO;
import com.capgemini.librarymanagement.dto.Users;

@Service
public class AdminServiceImplmnt implements AdminService {
	
	@Autowired
	private AdminDAO dao;

	@Override
	public Users addLibrarian(Users librarian) {
		return dao.addLibrarian(librarian);
	}

	@Override
	public Users updateLibrarian(Users librarian) {
		return dao.updateLibrarian(librarian);
	}

	@Override
	public Boolean deleteLibrarian(String librarianId) {
		return dao.deleteLibrarian(librarianId);
	}

	@Override
	public Users searchLibrarian(String librarianId) {
		return dao.searchLibrarian(librarianId);
	}

}
