package com.askconsultant.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.askconsultant.model.Person;

@Stateless
public class PersonDAO {
	public PersonDAO(){
		
	}
	
	@PersistenceContext
	EntityManager em;
	
	public Person addPerson(Person person){
		em.persist(person);
		return person;
	}
	
	public Person findByID(long personID){
		return em.find(Person.class, personID);
	}
	
	public List<Person> listAllPeople(){
		return em.createQuery("Select p From People p").getResultList();
	}

	public Person updatePerson(Person person) {
		return em.merge(person);
	}
	
	public void deletePerson(Person person){
		em.remove(person);
	}
}
