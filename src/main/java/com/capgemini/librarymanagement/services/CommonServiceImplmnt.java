package com.capgemini.librarymanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagement.dao.CommonDAO;
import com.capgemini.librarymanagement.dto.Users;
//import com.capgemini.librarymanagement.validations.BackendValidation;

@Service
public class CommonServiceImplmnt implements CommonService {
	@Autowired
	CommonDAO dao;

//	private BackendValidation validate = new BackendValidation();

	@Override
	public Users login(Users user) {
//		validate.validateId(user.getId());
//		validate.validateEmailId(user.getEmailId());
		return dao.login(user);
	}

}
