package com.askconsultant.dao;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.askconsultant.model.User;

public class TestUserDAO {

	private EntityManagerFactory emf;
	private EntityManager em;
	private UserDAO userDAO;

	@Before
	public void initTestCase() {
		emf = Persistence.createEntityManagerFactory("MessagePU");
		em = emf.createEntityManager();
		userDAO = new UserDAO();
		userDAO.em = em;
	}

	@After
	public void closeEntityManager() {
		em.close();
		emf.close();
	}
	
	@Test
	public void addUser(){
		User userForHappyPath = getUserForHappyPath();
		try{
			em.getTransaction().begin();
			User user = userDAO.addUser(userForHappyPath);
			em.getTransaction().commit();
			assertTrue(user.getId()!=0);
		}catch(Exception e){
			fail();
		}
	}

	private User getUserForHappyPath() {
		User user = new User();
		user.setPassword("somepassword");
		user.setUserid("someid");
		user.setEmail("someemail");
		return user;
	}
	
}
