package com.askconsultant.service;

import java.util.Map;

import javax.ejb.Local;

@Local
public interface EmployeeService {

	Map<String, String> getEmployeeConversationCategories(String userid);

}
