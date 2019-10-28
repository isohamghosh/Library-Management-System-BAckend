package com.capgemini.librarymanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagement.dto.Users;
import com.capgemini.librarymanagement.exception.CustomException;

@Repository
public class AdminDAOImplmnt implements AdminDAO {
	
	private String role = "Librarian";

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Override
	public Users addLibrarian(Users librarian) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			if (librarian.getRole() == null) {
				librarian.setRole(role);
				entityManager.persist(librarian);
				transaction.commit();
				entityManager.close();
			}
		} catch (Exception e) {
			transaction.rollback();
			throw new CustomException("Librarian not added");
		}

		return librarian;
	}// end of addLibrarian

	@Override
	public Users updateLibrarian(Users librarian) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			Users getUser = entityManager.find(Users.class, librarian.getId());
			if (getUser != null) {
				getUser.setId(librarian.getId());
				getUser.setName(librarian.getName());
				getUser.setEmailId(librarian.getEmailId());
				getUser.setPassword(librarian.getPassword());
				getUser.setRole(role);
				transaction.commit();
				entityManager.close();
			}
		} catch (Exception e) {
			transaction.rollback();
		}
		return librarian;
	}// end of updateLibrarian

	@Override
	public Boolean deleteLibrarian(String librarianId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			Users users = null;
			users = entityManager.find(Users.class, librarianId);
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
			throw new CustomException("Librarian not deleted");
		}
		entityManager.close();
		return true;
	}// end of delete

	@Override
	public List<Users> searchLibrarian() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		List<Users> users = null;
		transaction.begin();
		String query = "from Users where role=: role";
		Query getDetailsQuarry = entityManager.createQuery(query);
		getDetailsQuarry.setParameter("role", role);
		users = getDetailsQuarry.getResultList();
		transaction.commit();
		entityManager.close();
		return users;
	}// end of searchLibrarian
}