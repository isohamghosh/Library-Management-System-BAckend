package com.capgemini.librarymanagement.dao;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagement.dto.BooksInventory;
import com.capgemini.librarymanagement.dto.BooksRegistration;
import com.capgemini.librarymanagement.dto.BooksTransaction;
import com.capgemini.librarymanagement.exception.CustomException;

@Repository
public class StudentDAOImplmnt implements StudentDAO {
	
	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;

	@Override
	public List<BooksInventory> searchForBook(String bookName) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		List<BooksInventory> booksInventory = null;
		try {
			transaction.begin();
			String query = "from BooksInventory where bookName like concat ('%', :bookName, '%')";
			Query searchQuarry = entityManager.createQuery(query);
			searchQuarry.setParameter("bookName", bookName);
			booksInventory = searchQuarry.getResultList();
			transaction.commit();
			entityManager.close();
		} catch (Exception e) {
			throw new CustomException("No Book Found");
		}
		return booksInventory;
	}

	@Override
	public BooksRegistration makeBookRequest(String bookId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		BooksRegistration registration = new BooksRegistration();
		try {
			transaction.begin();
			Random random = new Random();
			registration.setRegistrationId(random.nextInt((1000 - 100) + 1) + 100);
			registration.setUserId(CommonDAOImplmnt.userId);
			registration.setBookId(bookId);
			registration.setRegistrationDate(LocalDate.now());
			entityManager.persist(registration);
			transaction.commit();
			entityManager.close();
		} catch (Exception e) {
			transaction.rollback();
			throw new CustomException("Librarian not added");
		}
		return registration;
	}

	@Override
	public Boolean cancelRequestedBook(Integer registrationId) {
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
			throw new CustomException("Failed to Cancel");
		}
		entityManager.close();
		return true;
	}

	@Override
	public List<BooksTransaction> getResponse() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		List<BooksTransaction> booksTransaction = null;
		try {
			transaction.begin();
			String query = "from BooksTransaction where studentId=: studentId";
			Query getDetailsQuarry = entityManager.createQuery(query);
			getDetailsQuarry.setParameter("studentId", CommonDAOImplmnt.userId);
			booksTransaction = getDetailsQuarry.getResultList();
			transaction.commit();
			entityManager.close();
		} catch (Exception e) {
			throw new CustomException("No Response");
		}
		return booksTransaction;
	}

	@Override
	public List<BooksRegistration> getAllRequestedBook() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		List<BooksRegistration> registeredBooks = null;
		try {
			transaction.begin();
			String query = "from BooksRegistration where userId=: userId ";
			Query getDetailsQuarry = entityManager.createQuery(query);
			getDetailsQuarry.setParameter("userId", CommonDAOImplmnt.userId);
			registeredBooks = getDetailsQuarry.getResultList();
			transaction.commit();
			entityManager.close();
		} catch (Exception e) {
			throw new CustomException("No Records Found");
		}
		return registeredBooks;
	}

	@Override
	public int returnBook(Integer transectionId) {
		int fine;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		BooksTransaction booksTransaction = null;
		booksTransaction = entityManager.find(BooksTransaction.class, transectionId);
		LocalDate returnDate = booksTransaction.getReturnDate();
		LocalDate todayDate = LocalDate.now();
		Period days = Period.between(todayDate, returnDate);
		if (days.getDays() > 0) {
			fine = days.getDays() * 10;
			booksTransaction.setFine(fine);
		} else {
			fine = 0;
			booksTransaction.setFine(0);
		}
		transaction.commit();
		entityManager.close();
		return fine;
	}

}
