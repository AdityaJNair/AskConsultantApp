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

public class EmployeeDAO {

	@PersistenceContext
	EntityManager em;
	
	public Employee addEmployee(Employee employee) {
		em.persist(employee);
		return employee;
	}
	
	public Employee getEmployeeByUserID(String userID) throws InvalidUserException{
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
		Root<Employee> root = criteriaQuery.from(Employee.class);
		criteriaQuery.select(root);

		ParameterExpression<String> params = criteriaBuilder.parameter(String.class);
		criteriaQuery.where(criteriaBuilder.equal(root.get("userid"), params));

		TypedQuery<Employee> query = em.createQuery(criteriaQuery);
		query.setParameter(params, userID);

		List<Employee> queryResult = query.getResultList();
		if (queryResult.isEmpty()){
			throw new InvalidUserException("Employee not present");
		}else return queryResult.get(0);
	}
	
}
