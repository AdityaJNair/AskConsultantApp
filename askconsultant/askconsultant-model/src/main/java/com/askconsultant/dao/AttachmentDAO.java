package com.askconsultant.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AttachmentDAO {

	@PersistenceContext
	EntityManager em;
}
