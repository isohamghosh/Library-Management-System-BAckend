package com.capgemini.librarymanagement.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.librarymanagement.exception.CustomException;

public class BackendValidation {

	public boolean validateId(String id) {
		Pattern pattern = Pattern.compile("\\d+\\d+\\d");
		Matcher matcher = pattern.matcher(id);
		if (matcher.matches()) {
			return true;
		} else {
			throw new CustomException("Enter a valid id");
		}
	}

	public boolean validateEmailId(String emailId) {
		Pattern pattern = Pattern.compile("\\w+\\@+\\w+\\.\\w+");
		Matcher matcher = pattern.matcher(emailId);
		if (matcher.matches()) {
			return true;
		} else {
			throw new CustomException("Enter a valid EmailId");
		}
	}

	public boolean validateyearOfPublication(String yearOfPublication) {
		Pattern pattern = Pattern.compile("\\d+\\d+\\d+\\d+");
		Matcher matcher = pattern.matcher(yearOfPublication);
		if (matcher.matches()) {
			return true;
		} else {
			throw new CustomException("Enter valid year");
		}
	}

	public boolean validatePassword(String password) {
		Pattern pattern = Pattern.compile("\\w+\\d+");
		Matcher matcher = pattern.matcher(password);
		if (matcher.matches()) {
			return true;
		} else {
			throw new CustomException("Invalid password..! Enter Valid Password");
		}
	}

}
