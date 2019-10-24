package com.capgemini.librarymanagement.services;

import java.util.List;

import com.capgemini.librarymanagement.dto.Users;

public interface AdminService {
	
	
	public Boolean addLibrarian(Users librarian);
	public Boolean updateLibrarian(Users librarian);
	public Boolean deleteLibrarian(String librarianId);
	public Users searchLibrarian(String librarianId);

}
