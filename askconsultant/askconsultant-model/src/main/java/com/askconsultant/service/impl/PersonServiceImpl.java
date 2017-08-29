package com.askconsultant.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.askconsultant.dao.PersonDAO;
import com.askconsultant.model.Person;
import com.askconsultant.service.PersonService;

@Stateless
public class PersonServiceImpl implements PersonService {
	public PersonServiceImpl(){
		
	}
	
	@Inject
	private PersonDAO personDAO;
	
	@Override
	public List<Person> listAllPeople(){
		return personDAO.listAllPeople();
	}

	@Override
	public Person addPerson(Person person) {
		return personDAO.addPerson(person);
	}

	@Override
	public Person updatePerson(Person person) {
		return personDAO.updatePerson(person);
	}
}
