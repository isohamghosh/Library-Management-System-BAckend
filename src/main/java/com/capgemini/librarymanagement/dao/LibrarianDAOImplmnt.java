package com.capgemini.librarymanagement.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagement.dto.BooksInventory;
import com.capgemini.librarymanagement.dto.BooksRegistration;
import com.capgemini.librarymanagement.dto.BooksTransaction;
import com.capgemini.librarymanagement.dto.Users;
import com.capgemini.librarymanagement.exception.CustomException;

@Repository
public class LibrarianDAOImplmnt implements LibrarianDAO {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");

	@Override
	public BooksInventory addNewBook(BooksInventory booksInvent) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(booksInvent);
			transaction.commit();
			entityManager.close();
		} catch (Exception e) {
			transaction.rollback();
			throw new CustomException("Book not added");
		}
		return booksInvent;
	}// end of addLibrarian

	@Override
	public BooksInventory updateBook(BooksInventory booksInvent) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			BooksInventory selecetdBook = entityManager.find(BooksInventory.class, booksInvent.getBookId());
			selecetdBook.setBookName(booksInvent.getBookName());
			selecetdBook.setfirstAuthor(booksInvent.getfirstAuthor());
			selecetdBook.setsecondAuthor(booksInvent.getsecondAuthor());
			selecetdBook.setPublisher(booksInvent.getPublisher());
			selecetdBook.setYearofpublication(booksInvent.getYearOfPublication());
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			throw new CustomException("Enter the valid book id");
		}
		return booksInvent;
	}// end of updateLibrarian

	@Override
	public Boolean deleteBook(String bookId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			BooksInventory booksInventory = null;
			booksInventory = entityManager.find(BooksInventory.class, bookId);
			if (booksInventory == null) {
				return false;
			} else {
				transaction.begin();
				entityManager.remove(booksInventory);
				transaction.commit();
				entityManager.close();
			}
		} catch (Exception e) {
			transaction.rollback();
			throw new CustomException("Enter a valid Book Id");
		}
		entityManager.close();
		return true;
	}// end of deleteBook

	@Override
	public List<BooksRegistration> getBookRequest() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		List<BooksRegistration> registeredBooks = null;
		try {
			transaction.begin();
			String query = "from BooksRegistration";
			Query getDetailsQuarry = entityManager.createQuery(query);
			registeredBooks = getDetailsQuarry.getResultList();
			transaction.commit();
			entityManager.close();
		} catch (Exception e) {
			throw new CustomException("No Records Found");
		}
		return registeredBooks;
	}

	@Override
	public Boolean cancelBookRequest(Integer registrationId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		BooksRegistration id = entityManager.find(BooksRegistration.class, registrationId);
		try {
			if (id == null) {
				return false;
			} else {
				transaction.begin();
				entityManager.remove(id);
				transaction.commit();
				entityManager.close();
			}
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		entityManager.close();
		return true;
	}

	@Override
	public Users addNewStudent(Users student) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			if(student.getRole() == null) {
			student.setRole("Student");
			entityManager.persist(student);
			transaction.commit();
			entityManager.close();
			}
		} catch (Exception e) {
			transaction.rollback();
			throw new CustomException("Student not added");
		}
		return student;
	}// end of addNewStudent

	@Override
	public List<Users> searchStudent() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		List<Users> users = null;
		try {
			transaction.begin();
			String query = "from Users where role=: role ";
			Query searchQuarry = entityManager.createQuery(query);
			searchQuarry.setParameter("role", "Student");
			users = searchQuarry.getResultList();
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			throw new CustomException("No Student Found");
		}
		return users;
	}

	@Override
	public Boolean deleteStudent(String studentId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			Users users = null;
			users = entityManager.find(Users.class, studentId);
			if (users == null) {
				return false;
			} else {
				transaction.begin();
				entityManager.remove(users);
				transaction.commit();
				entityManager.close();
			}
		} catch (Exception e) {
			transaction.rollback();
			throw new CustomException("Enter a valid Student Id");
		}
		entityManager.close();
		return true;
	}// end of deleteStudent

	@Override
	public BooksTransaction responseBookRequest(Integer registrationId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		BooksTransaction booksTransaction = new BooksTransaction();
		try {
			transaction.begin();
			Random random = new Random();
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DATE, 15);
			Date returnDate = calendar.getTime();
			booksTransaction.setTransactionId(random.nextInt((3000 - 1000) + 1) + 1000);
			booksTransaction.setRegistrationId(registrationId);
			booksTransaction.setIssueDate(new Date());
			booksTransaction.setReturnDate(returnDate);
			booksTransaction.setFine(0);
			booksTransaction.setStudentId(CommonDAOImplmnt.userId);
			entityManager.persist(booksTransaction);
			BooksRegistration regId = entityManager.find(BooksRegistration.class, registrationId);
			entityManager.remove(regId);
			transaction.commit();
			entityManager.close();
		} catch (Exception e) {
			transaction.rollback();
			throw new CustomException("Failed to response");
		}

		return booksTransaction;
	}
}
