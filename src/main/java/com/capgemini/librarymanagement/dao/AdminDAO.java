package com.capgemini.librarymanagement.dao;

import java.util.List;

import com.capgemini.librarymanagement.dto.Users;

public interface AdminDAO {

	public Users addLibrarian(Users librarian);

	public Users updateLibrarian(Users librarian);

	public Boolean deleteLibrarian(String librarianId);

	public List<Users> searchLibrarian();

}
