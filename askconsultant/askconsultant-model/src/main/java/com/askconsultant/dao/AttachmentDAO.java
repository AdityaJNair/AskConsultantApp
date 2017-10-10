package com.askconsultant.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * This can be used later for managing attachments. Feature not implemented for the project.
 *
 */
@Stateless
public class AttachmentDAO {

	@PersistenceContext
	EntityManager em;
}
