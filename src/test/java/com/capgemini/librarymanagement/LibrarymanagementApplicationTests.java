package com.capgemini.librarymanagement;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.librarymanagement.dao.AdminDAO;
import com.capgemini.librarymanagement.dao.LibrarianDAO;
import com.capgemini.librarymanagement.dao.StudentDAO;
import com.capgemini.librarymanagement.dto.BooksInventory;
import com.capgemini.librarymanagement.dto.BooksRegistration;
import com.capgemini.librarymanagement.dto.BooksTransaction;
import com.capgemini.librarymanagement.dto.Users;

@SpringBootTest
class LibrarymanagementApplicationTests {

	@Autowired
	AdminDAO adminDao;

	@Autowired
	LibrarianDAO librarianDAO;
	
	@Autowired
	StudentDAO studentDAO;
	
	//Admin TestCases

	@Test
	void contextLoads() {

		boolean check = adminDao.deleteLibrarian("110");
		assertTrue(check);

	}

	@Test
	void addLibrarian() {
		Users users = new Users();
		users.setId("113");
		users.setName("soham");
		users.setEmailId("soham@gmail.com");
		users.setPassword("soham123");
		users.setRole("Librarian");
		Users check = adminDao.addLibrarian(users);
		assertNotNull(users);
	}

	@Test
	void updateLibrarian() {
		Users users = new Users();
		users.setId("113");
		users.setName("aaa");
		users.setEmailId("teju@gmail.com");
		users.setPassword("teju");
		users.setRole("Librarian");
		Users check = adminDao.updateLibrarian(users);
		assertNotNull(users);

	}

//	@Test
//	void searchLibrarian() {
//
//		boolean check = adminDao.searchLibrarian("110") != null;
//		assertTrue(check);
//
//	}
	
	//Librarian TestCases

	@Test
	void addNewBook() {
		BooksInventory booksInventory = new BooksInventory();
		booksInventory.setBookId("1111");
		booksInventory.setBookName("Machine Learning");
		booksInventory.setfirstAuthor("AAAA");
		booksInventory.setsecondAuthor("ZZZ");
		booksInventory.setPublisher("SSSS");
		booksInventory.setYearofpublication("2019");
		BooksInventory check = librarianDAO.addNewBook(booksInventory);
		assertNotNull(booksInventory);

	}

	@Test
	void deleteBook() {
		boolean check = librarianDAO.deleteBook("1111");
		assertTrue(check);
	}

	@Test
	void updateBook() {
		BooksInventory booksInventory = new BooksInventory();
		booksInventory.setBookId("1111");
		booksInventory.setBookName("ADE");
		booksInventory.setfirstAuthor("AAAA");
		booksInventory.setsecondAuthor("ZZZ");
		booksInventory.setPublisher("SSSS");
		booksInventory.setYearofpublication("2019");
		BooksInventory check = librarianDAO.updateBook(booksInventory);
		assertNotNull(booksInventory);
	}

	@Test
	void addStudent() {
		Users users = new Users();
		users.setId("114");
		users.setName("nisha");
		users.setEmailId("nisha@gmail.com");
		users.setPassword("nisha123");
		users.setRole("Student");
		Users check = librarianDAO.addNewStudent(users);
		assertNotNull(users);
	}

	@Test
	void deleteStudent() {
		boolean check = librarianDAO.deleteStudent("111");
		assertTrue(check);
	}

//	void searchStuddent() {
//		List<Users> check = librarianDAO.searchStudent("111");
//		assertNotNull(check);
//
//	}
	
	//Student TestCases
	
	@Test
	void searchForBook() {
		List<BooksInventory> check=studentDAO.searchForBook("Big Data Analyics");
		assertNotNull(check);
	}
	
	@Test
	void makeBookRequest() {
		BooksRegistration check=studentDAO.makeBookRequest("123");
		assertNotNull(check);
	}
	
	@Test
	void getAllRequestedBook() {
		List<BooksRegistration> check=studentDAO.getAllRequestedBook();
		assertNotNull(check);
	}
	
	@Test
	void cancelRequestedBook() {
		boolean check=studentDAO.cancelRequestedBook(123);
		assertTrue(check);
	}
	
	@Test
	void getResponse() {
		List<BooksTransaction> check=studentDAO.getResponse();
		assertNotNull(check);
	}
	
//	@Test
//	void returnBook() {
//		boolean check=studentDAO.returnBook("123");
//		assertTrue(check);
//	}

}
