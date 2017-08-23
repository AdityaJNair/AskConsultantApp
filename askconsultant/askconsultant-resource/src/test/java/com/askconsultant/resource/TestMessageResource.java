package com.askconsultant.resource;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.askconsultant.service.MessageService;

public class TestMessageResource {

	MessageResource messageResource;
	
	@Mock
	private MessageService messageService;
	
	@Before
	public void initTestCase(){
		MockitoAnnotations.initMocks(this);
		messageResource = new MessageResource();
		messageResource.messageService = messageService;
	}
	
	@Test
	public void addMessage(){
		
	}
}
