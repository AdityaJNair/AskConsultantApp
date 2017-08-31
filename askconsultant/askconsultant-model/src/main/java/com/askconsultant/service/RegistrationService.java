package com.askconsultant.service;

import javax.ejb.Local;

import com.askconsultant.service.dto.User;

@Local
public interface RegistrationService {

	public void register(User userDetails) throws Exception;
}
