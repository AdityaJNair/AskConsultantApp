package com.askconsultant.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import com.askconsultant.dao.EmployeeDAO;
import com.askconsultant.exception.InvalidUserException;
import com.askconsultant.model.Employee;
import com.askconsultant.service.EmployeeService;

/**
 *
 */
public class EmployeeServiceImpl implements EmployeeService {

	@Inject
	EmployeeDAO employeeDAO;
	
	/**
	 * @param userid
	 * @return
	 */
	@Override
	public Map<String,String>  getEmployeeConversationCategories(String userid) {
		Employee employeeByUserID;
		Map<String,String> topics = new  HashMap<String,String>();
		try {
			employeeByUserID = employeeDAO.getEmployeeByUserID(userid);
		} catch (InvalidUserException e) {
			return topics;
		}
		topics.put("primaryTopic",employeeByUserID.getPrimaryTopic());
		topics.put("primarySubtopic",employeeByUserID.getPrimarySubTopic());
		return topics;
	}
	
}
