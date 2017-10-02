package com.askconsultant.dao;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.askconsultant.model.RegistrationDetails;

public class TestRegistrationDAO {

	private EntityManagerFactory emf;
	private EntityManager em;
	private RegistrationDAO registrationDAO;

	@Before
	public void initTestCase() {
		emf = Persistence.createEntityManagerFactory("MessagePU");
		em = emf.createEntityManager();
		registrationDAO = new RegistrationDAO();
		registrationDAO.em = em;
	}

	@After
	public void closeEntityManager() {
		em.close();
		emf.close();
	}

	@Test
	public void addRegistrationDetails() {
		RegistrationDetails registrationDetailsForHappyPath = getRegistrationDetailsForHappyPath();
		try {
			em.getTransaction().begin();
			RegistrationDetails addRegistrationDetails = registrationDAO
					.addRegistrationDetails(registrationDetailsForHappyPath);
			em.getTransaction().commit();
			assertTrue(addRegistrationDetails.getId() != 0l);
		} catch (Exception e) {
			fail();
		}
	}

	public static RegistrationDetails getRegistrationDetailsForHappyPath() {
		RegistrationDetails registrationDetails = new RegistrationDetails();
		registrationDetails.setFirstName("somename");
		registrationDetails.setUserid("someone");
		return registrationDetails;
	}

	
	@Test
	public void findByUserID() {
		RegistrationDetails registrationDetailsForHappyPath = getRegistrationDetailsForHappyPath();
		try {
			em.getTransaction().begin();
			RegistrationDetails addRegistrationDetails = registrationDAO
					.addRegistrationDetails(registrationDetailsForHappyPath);
			em.getTransaction().commit();
			//fetch the registration object
			RegistrationDetails findByUserID = registrationDAO.findByUserID(addRegistrationDetails.getUserid());
			assertNotNull(findByUserID);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
}
