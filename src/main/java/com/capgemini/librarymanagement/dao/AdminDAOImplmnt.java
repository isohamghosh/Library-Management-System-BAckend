package com.capgemini.librarymanagement.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagement.dto.Users;
@Repository
public class AdminDAOImplmnt implements AdminDAO {
	static EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("TestPersistence");
	EntityManager entityManager=entityManagerFactory.createEntityManager();;
	EntityTransaction transaction=null;


	@Override
	public Boolean addStudent(Users student) {

		
		return null;
	}

	@Override
	public Users addLibrarian(Users librarian) {
		try {
			entityManager= entityManagerFactory.createEntityManager();
			transaction= entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(librarian);
			transaction.commit();
			entityManager.close();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return librarian;
	}

	@Override
	public Boolean updateStudent(Users student) {

		
		return null;
	}

	@Override
	public Boolean updateLibrarian(Users librarian) {

		
		return null;
	}

	@Override
	public Boolean deleteStudent(String studentId) {

		return null;
	}

	@Override
	public Users deleteLibrarian(String librarianId) {
		Users users = null;
		try {
			entityManager= entityManagerFactory.createEntityManager();
			transaction= entityManager.getTransaction();
			transaction.begin();
			users=entityManager.find(Users.class, librarianId);
			entityManager.remove(users);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		
		return users;
	}

	@Override
	public Users searchLibrarian(String librarianId) {

		
		return null;
	}

}
