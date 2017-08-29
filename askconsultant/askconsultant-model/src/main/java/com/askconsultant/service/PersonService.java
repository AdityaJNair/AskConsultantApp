package com.askconsultant.service;

import java.util.List;

import javax.ejb.Local;

import com.askconsultant.model.Person;

@Local
public interface PersonService {
	Person addPerson(Person person);
	List listAllPeople();
	Person updatePerson(Person person);
}
