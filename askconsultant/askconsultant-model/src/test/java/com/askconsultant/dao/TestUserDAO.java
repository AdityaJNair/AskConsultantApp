package com.askconsultant.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.askconsultant.model.User;

/**
 * Tests UserDAO class
 *
 */
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

	/**
	 * Tests saving the User object to the database
	 */
	@Test
	public void addUser() {
		User userForHappyPath = getUserForHappyPath();
		try {
			em.getTransaction().begin();
			User user = userDAO.addUser(userForHappyPath);
			em.getTransaction().commit();
			assertTrue(user.getId() != 0);
		} catch (Exception e) {
			fail();
		}
	}

	/**
	 *  Utility method to get a dummy user
	 */
	private User getUserForHappyPath() {
		User user = new User();
		user.setPassword("somepassword");
		user.setUserid("someid");
		return user;
	}

	/**
	 * Tests fetching a stored User from the database for a 
	 * happy path scenario
	 */
	@Test
	public void getUserByUserID_ValidUser() {
		try {
			em.getTransaction().begin();
			User user = userDAO.addUser(getUserForHappyPath());
			em.getTransaction().commit();
			User userByUserID = userDAO.getUserByUserID(user.getUserid());
			assertNotNull(userByUserID);
		} catch (Exception e) {
			fail();
		}
	}
	
	/**
	 * Tests fetching of user when the user is not present
	 */
	@Test
	public void getUserByUserID_UserNotExist() {
		try {
			em.getTransaction().begin();
			userDAO.getUserByUserID("someuser");
			fail();
		} catch (Exception e) {
			assertEquals("User not present", e.getMessage());
		}
	}
}
