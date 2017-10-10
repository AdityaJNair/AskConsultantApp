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

import com.askconsultant.model.Employee;

/**
 * Tests the EmployeeDAO class
 *
 */
public class TestEmployeeDAO {

	private EntityManagerFactory emf;
	private EntityManager em;
	private EmployeeDAO employeeDAO;

	@Before
	public void initTestCase() {
		emf = Persistence.createEntityManagerFactory("MessagePU");
		em = emf.createEntityManager();
		employeeDAO = new EmployeeDAO();
		employeeDAO.em = em;
	}

	@After
	public void closeEntityManager() {
		em.close();
		emf.close();
	}

	@Test
	public void addEmployee() {
		em.getTransaction().begin();
		Employee employeeDetailsForHappyPath = getEmployeeDetailsForHappyPath();
		try {
			Employee addEmployee = employeeDAO.addEmployee(employeeDetailsForHappyPath);
			em.getTransaction().commit();
			assertTrue(addEmployee.getId() != 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

	}

	public static Employee getEmployeeDetailsForHappyPath() {
		Employee employee = new Employee();
		employee.setUserid("someUser");
		employee.setPassword("somepassword");
		employee.setName("Test Name");
		employee.setPrimarySubTopic("Primary Subtopic");
		employee.setPrimaryTopic("Primary topic");
		employee.setRole("role");
		return employee;
	}

	@Test
	public void getEmployeeByUserID_ValidEmployee() {
		em.getTransaction().begin();
		Employee employeeDetailsForHappyPath = getEmployeeDetailsForHappyPath();
		try {
			Employee addEmployee = employeeDAO.addEmployee(employeeDetailsForHappyPath);
			em.getTransaction().commit();
			Employee employeeByUserID = employeeDAO.getEmployeeByUserID(addEmployee.getUserid());
			assertNotNull(employeeByUserID);
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void getEmployeeByUserID_InvalidEmployee() {
		try {
			em.getTransaction().begin();
			employeeDAO.getEmployeeByUserID("invalidEmployee");
			fail();
		} catch (Exception e) {
			assertEquals("Employee not present", e.getMessage());
		}
	}

}
