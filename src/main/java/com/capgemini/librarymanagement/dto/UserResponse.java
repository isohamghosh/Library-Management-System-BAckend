package com.capgemini.librarymanagement.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.capgemini.librarymanagement.dto.BooksInventory;
import com.capgemini.librarymanagement.dto.Users;

public class UserResponse {
	
	@XmlElement(name="status-code")
	private int statusCode;
	@XmlElement
	private String message;
	@XmlElement
	private String description;
	@XmlElement
	private Users librarians;

	private List<Users> alllibrarians;
	
	private Boolean booksInventory;
	
	private List<BooksInventory> allbooks;
	
	private List<Users> students;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Users getLibrarians() {
		return librarians;
	}

	public void setLibrarians(Users librarians) {
		this.librarians = librarians;
	}

	public List<Users> getAllLibrarians() {
		return alllibrarians;
	}

	public void setAllLibrarians(List<Users> alllibrarians) {
		this.alllibrarians = alllibrarians;
	}

	public Boolean getBooksInventory() {
		return booksInventory;
	}

	public void setBooksInventory(Boolean bookInventory) {
		this.booksInventory = bookInventory;
	}

	public List<BooksInventory> getAllbooks() {
		return allbooks;
	}

	public void setAllbooks(List<BooksInventory> allbooks) {
		this.allbooks = allbooks;
	}
	

	public List<Users> getStudents() {
		return students;
	}

	public void setStudents(List<Users> students) {
		this.students = students;
	}
	

}
