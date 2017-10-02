package com.askconsultant.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import com.askconsultant.model.RegistrationDetails;

public class RegistrationDAO {

	@PersistenceContext
	EntityManager em;

	public RegistrationDetails findByUserID(String userID) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<RegistrationDetails> criteriaQuery = criteriaBuilder.createQuery(RegistrationDetails.class);
		Root<RegistrationDetails> root = criteriaQuery.from(RegistrationDetails.class);
		criteriaQuery.select(root);

		ParameterExpression<String> params = criteriaBuilder.parameter(String.class);
		criteriaQuery.where(criteriaBuilder.equal(root.get("userid"), params));

		TypedQuery<RegistrationDetails> query = em.createQuery(criteriaQuery);
		query.setParameter(params, userID);

		List<RegistrationDetails> queryResult = query.getResultList();
		if (!queryResult.isEmpty()) {
			return queryResult.get(0);
		} else
			return null;

	}
	
	public RegistrationDetails addRegistrationDetails(RegistrationDetails registrationDetails){
		em.persist(registrationDetails);
		return registrationDetails;
	}

	public RegistrationDetails updateRegistrationDetails(RegistrationDetails registrationDetails) {
		return em.merge(registrationDetails);
	}

	public void deleteRegistrationDetails(RegistrationDetails registrationDetails) {
		em.remove(registrationDetails);
	}

}
