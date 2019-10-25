package com.capgemini.librarymanagement.dao;

import com.capgemini.librarymanagement.dto.Users;

public interface AdminDAO {
	
	public Boolean addStudent(Users student);
	public Users addLibrarian(Users librarian);
	public Boolean updateStudent(Users student);
	public Boolean updateLibrarian(Users librarian);
	public Boolean deleteStudent(String studentId);
	public Users deleteLibrarian(String librarianId);
	public Users searchLibrarian(String librarianId);

}
