package com.capgemini.librarymanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagement.dto.Users;

@Repository
public class CommonDAOImplmnt implements CommonDAO {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction transaction = entityManager.getTransaction();
	static String userId;

	@Override
	public Users login(Users user) {
		transaction.begin();
		String jpql = "from Users where id= :id  and password= :password";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("id", user.getId());
		query.setParameter("password", user.getPassword());
		List<Users> users = query.getResultList();
		if (users.size() > 0) {
			user = users.get(0);
			transaction.commit();
			entityManager.close();
			CommonDAOImplmnt.userId = user.getId();
		}
		return user;
	}

}
