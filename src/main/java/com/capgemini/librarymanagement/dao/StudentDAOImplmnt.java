package com.capgemini.librarymanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagement.dto.BooksInventory;
import com.capgemini.librarymanagement.exception.CustomException;

@Repository
public class StudentDAOImplmnt implements StudentDAO {

	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("TestPersistence");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction transaction=entityManager.getTransaction();

	@Override
	public List<BooksInventory> searchForBook(String bookName) {
		List<BooksInventory> booksInventory=null;
		try {
			transaction.begin();
			String query = "from BooksInventory where bookName=: bookName ";
			Query searchQuarry = entityManager.createQuery(query);
			searchQuarry.setParameter("bookName", bookName);
			booksInventory = searchQuarry.getResultList();
			transaction.commit();
			entityManager.close();
		}catch (Exception e) {
			throw new CustomException("No Book Found");
		}
		return booksInventory;
	}

	@Override
	public BooksInventory makeBookRequest(BooksInventory booksInvent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean cancelRequestedBook(BooksInventory booksInvent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean getResponse(BooksInventory booksInvent) {
		// TODO Auto-generated method stub
		return null;
	}

}
