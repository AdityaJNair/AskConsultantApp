package com.askconsultant.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import com.askconsultant.exception.InvalidUserException;
import com.askconsultant.model.Employee;

/**
 * Data access class for Employee object
 *
 */
public class EmployeeDAO {

	@PersistenceContext
	EntityManager em;

	/**
	 * Adds employee object to the database
	 * @param employee
	 * @return
	 */
	public Employee addEmployee(Employee employee) {
		em.persist(employee);
		return employee;
	}

	/**
	 * Retrieves employee object by id
	 * @param userID
	 * @return
	 * @throws InvalidUserException
	 */
	public Employee getEmployeeByUserID(String userID) throws InvalidUserException {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
		Root<Employee> root = criteriaQuery.from(Employee.class);
		criteriaQuery.select(root);

		ParameterExpression<String> params = criteriaBuilder.parameter(String.class);
		criteriaQuery.where(criteriaBuilder.equal(root.get("userid"), params));

		TypedQuery<Employee> query = em.createQuery(criteriaQuery);
		query.setParameter(params, userID);

		List<Employee> queryResult = query.getResultList();
		if (queryResult.isEmpty()) {
			throw new InvalidUserException("Employee not present");
		} else
			return queryResult.get(0);
	}
	
	/**
	 * Checks if an employee is present or not
	 * @param userid
	 * @return
	 */
	public boolean isEmployeeRegistered(String userid) {
		boolean isEmployeePresent = true;
		try {
			Employee employee = this.getEmployeeByUserID(userid);
		} catch (InvalidUserException e) {
			isEmployeePresent = false;
		}
		return isEmployeePresent;
	}
	

}
