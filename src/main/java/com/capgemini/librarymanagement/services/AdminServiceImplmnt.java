package com.capgemini.librarymanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagement.dao.AdminDAO;
import com.capgemini.librarymanagement.dto.Users;
import com.capgemini.librarymanagement.validations.BackendValidation;

@Service
public class AdminServiceImplmnt implements AdminService {
	
	@Autowired
	private AdminDAO dao;
	
	private BackendValidation validate = new BackendValidation();

	@Override
	public Users addLibrarian(Users librarian) {
		validate.validateId(librarian.getId());
		validate.validateEmailId(librarian.getEmailId());
		return dao.addLibrarian(librarian);
	}

	@Override
	public Users updateLibrarian(Users librarian) {
		validate.validateId(librarian.getId());
		validate.validateEmailId(librarian.getEmailId());
		return dao.updateLibrarian(librarian);
	}

	@Override
	public Boolean deleteLibrarian(String librarianId) {
		validate.validateId(librarianId);
		return dao.deleteLibrarian(librarianId);
	}

	@Override
	public Users searchLibrarian(String librarianId) {
		validate.validateId(librarianId);
		return dao.searchLibrarian(librarianId);
	}

}
