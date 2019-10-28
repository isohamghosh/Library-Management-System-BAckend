package com.capgemini.librarymanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarymanagement.dto.Users;
import com.capgemini.librarymanagement.services.CommonService;

@CrossOrigin(origins = "*", allowedHeaders = "*",allowCredentials = "true")
@RestController
public class CommonController {

	@Autowired
	private CommonService commonService;

	@PostMapping("user/login")
	public Users logIn(@RequestBody Users user) {
		return commonService.login(user);
	}
}
