package com.capgemini.librarymanagement.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagement.dto.Users;
import com.capgemini.librarymanagement.exception.CustomException;

@Repository
public class AdminDAOImplmnt implements AdminDAO {
	
	@PersistenceUnit
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("TestPersistence");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction transaction=entityManager.getTransaction();
	@Override
	public Users addLibrarian(Users librarian) {
		
		try {
			transaction.begin();
			entityManager.persist(librarian);
			transaction.commit();
			entityManager.close();
		} catch(Exception e) {
			transaction.rollback();
			throw new CustomException("Librarian not added");
		}
			return librarian;
	}//end of addLibrarian


	@Override
	public Users updateLibrarian(Users librarian) {
		try {
			if(searchLibrarian(librarian.getId())!=null) {
				return librarian;
			}else {
				transaction.begin();
				entityManager.merge(librarian);
				transaction.commit();
				entityManager.close();
			}
		}catch(Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return librarian;
	}//end of updateLibrarian

	@Override
	public Boolean deleteLibrarian(String librarianId) {
		try {
		Users users=null;
		users=entityManager.find(Users.class, librarianId);
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
			e.printStackTrace();
		}
		entityManager.close();
		return true;
		}//end of delete

	@Override
	public Users searchLibrarian(String librarianId) {
		Users users=null;
		users=entityManager.find(Users.class, librarianId);
				if(users!=null) {	
				}else {
					return users;
				}
				entityManager.close();
				return users;
	}//end of searchLibrarian
}