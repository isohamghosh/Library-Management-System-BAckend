package com.capgemini.librarymanagement.dao;

import com.capgemini.librarymanagement.dto.Users;

public interface AdminDAO {
	
	public Users addLibrarian(Users librarian);
	public Users updateLibrarian(Users librarian);
	public Boolean deleteLibrarian(String librarianId);
	public Users searchLibrarian(String librarianId);

}
