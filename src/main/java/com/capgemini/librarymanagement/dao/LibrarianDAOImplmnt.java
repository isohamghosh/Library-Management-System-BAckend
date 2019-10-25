package com.capgemini.librarymanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagement.dto.BooksInventory;
import com.capgemini.librarymanagement.dto.Users;
import com.capgemini.librarymanagement.exception.CustomException;

@Repository
public class LibrarianDAOImplmnt implements LibrarianDAO {

	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("TestPersistence");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction transaction=entityManager.getTransaction();
	@Override
	public BooksInventory addNewBook(BooksInventory booksInvent) {
		try {
			transaction.begin();
			entityManager.persist(booksInvent);
			transaction.commit();
			entityManager.close();
		} catch(Exception e) {
			transaction.rollback();
			throw new CustomException("Book not added");
		}
			return booksInvent;
	}//end of addLibrarian

	@Override
	public BooksInventory updateBook(BooksInventory booksInvent) {
		
		try {
			transaction.begin();
			BooksInventory selecetdBook = entityManager.find(BooksInventory.class, booksInvent.getBookId());
			selecetdBook.setBookName(booksInvent.getBookName());
			selecetdBook.setfirstAuthor(booksInvent.getfirstAuthor());
			selecetdBook.setsecondAuthor(booksInvent.getsecondAuthor());
			selecetdBook.setPublisher(booksInvent.getPublisher());
			selecetdBook.setYearofpublication(booksInvent.getYearOfPublication());
			transaction.commit();
		}catch(Exception e) {
			transaction.rollback();
			throw new CustomException("Enter the valid book id");
		}
		return booksInvent;
	}//end of updateLibrarian

	@Override
	public Boolean deleteBook(String bookId) {
		try {
		BooksInventory booksInventory=null;
		booksInventory=entityManager.find(BooksInventory.class, bookId);
			if(booksInventory==null) {
				return false;
			}else {
				transaction.begin();
				entityManager.remove(booksInventory);
				transaction.commit();
				entityManager.close();
			}
		}catch(Exception e) {
			transaction.rollback();
			throw new CustomException("Enter a valid Book Id");
		}
		entityManager.close();
		return true;
		}//end of deleteBook

	@Override
	public BooksInventory getBookRequest(BooksInventory booksInvent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean cancelBookRequest(String bookId, String bookName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> searchStudent(String studentId) {
		List<Users> users=null;
		try {
			transaction.begin();
			String query = "from Users where id=: studentId ";
			Query searchQuarry = entityManager.createQuery(query);
			searchQuarry.setParameter("id", studentId);
			users = searchQuarry.getResultList();
			entityManager.getTransaction().commit();
			entityManager.close();
		}catch (Exception e) {
			throw new CustomException("No Student Found");
		}
		return users;
	}

	@Override
	public Boolean deleteStudent(String studentId) {
		try {
		Users users=null;
		users=entityManager.find(Users.class, studentId);
			if(users==null) {
				return false;
			}else {
				transaction.begin();
				entityManager.remove(users);
				transaction.commit();
				entityManager.close();
			}
		}catch(Exception e) {
			transaction.rollback();
			throw new CustomException("Enter a valid Student Id");
		}
		entityManager.close();
		return true;
		}//end of deleteStudent
	}

