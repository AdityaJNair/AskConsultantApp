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
import com.askconsultant.model.User;

public class UserDAO {

	@PersistenceContext
	EntityManager em;

	public User addUser(User user) {
		em.persist(user);
		return user;
	}

	public User getUserByUserID(String userID) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		Root<User> root = criteriaQuery.from(User.class);
		criteriaQuery.select(root);

		ParameterExpression<String> params = criteriaBuilder.parameter(String.class);
		criteriaQuery.where(criteriaBuilder.equal(root.get("userid"), params));

		TypedQuery<User> query = em.createQuery(criteriaQuery);
		query.setParameter(params, userID);

		List<User> queryResult = query.getResultList();
		if (queryResult.isEmpty()){
			throw new InvalidUserException(Constants.USER_NOT_PRESENT);
		}else return queryResult.get(0);
	}
}
