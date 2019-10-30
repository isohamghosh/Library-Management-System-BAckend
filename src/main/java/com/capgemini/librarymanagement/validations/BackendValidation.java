package com.capgemini.librarymanagement.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.librarymanagement.exception.CustomException;

public class BackendValidation {

	public String validateId(String id) {
		Pattern pattern = Pattern.compile("\\d+\\d+\\d");
		Matcher matcher = pattern.matcher(id);
		if (matcher.matches()) {
			return id;
		} else {
			throw new CustomException("Enter a valid id");
		}
	}

	public String validateEmailId(String emailId) {
		Pattern pattern = Pattern.compile("\\w+\\@+\\w+\\.\\w+");
		Matcher matcher = pattern.matcher(emailId);
		if (matcher.matches()) {
			return emailId;
		} else {
			throw new CustomException("Enter a valid EmailId");
		}
	}

	public String validateyearOfPublication(String yearOfPublication) {
		Pattern pattern = Pattern.compile("\\d+\\d+\\d+\\d+");
		Matcher matcher = pattern.matcher(yearOfPublication);
		if (matcher.matches()) {
			return yearOfPublication;
		} else {
			throw new CustomException("Enter valid year");
		}
	}

	public String validatePassword(String password) {
		Pattern pattern = Pattern.compile("\\w+\\d+");
		Matcher matcher = pattern.matcher(password);
		if (matcher.matches()) {
			return password;
		} else {
			throw new CustomException("Invalid password..! Enter Valid Password");
		}
	}

}
