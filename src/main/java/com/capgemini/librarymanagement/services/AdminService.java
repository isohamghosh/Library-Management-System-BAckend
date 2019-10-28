package com.capgemini.librarymanagement.services;

import java.util.List;

import com.capgemini.librarymanagement.dto.Users;

public interface AdminService {

	public Users addLibrarian(Users librarian);

	public Users updateLibrarian(Users librarian);

	public Boolean deleteLibrarian(String librarianId);

	public List<Users> searchLibrarian();

}
