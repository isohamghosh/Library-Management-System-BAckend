package com.capgemini.librarymanagement.services;

import java.util.List;

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
		if (validate.validateId(librarian.getId()) && validate.validateEmailId(librarian.getEmailId())) {
			return dao.addLibrarian(librarian);
		} else {
			return null;
		}
	}

	@Override
	public Users updateLibrarian(Users librarian) {
		if (validate.validateId(librarian.getId()) && validate.validateEmailId(librarian.getEmailId())) {
			return dao.updateLibrarian(librarian);
		} else {
			return null;
		}
	}

	@Override
	public Boolean deleteLibrarian(String librarianId) {
		if(validate.validateId(librarianId)) {
			return dao.deleteLibrarian(librarianId);
		} else {
			return null;
		}
	}

	@Override
	public List<Users> searchLibrarian() {
		return dao.searchLibrarian();
	}

}
