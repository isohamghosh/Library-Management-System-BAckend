package com.capgemini.librarymanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagement.dao.CommonDAO;
import com.capgemini.librarymanagement.dto.Users;

@Service
public class CommonServiceImplmnt implements CommonService {
	@Autowired
	CommonDAO dao;

	@Override
	public Users login(Users user) {
		return dao.login(user);
	}

}
