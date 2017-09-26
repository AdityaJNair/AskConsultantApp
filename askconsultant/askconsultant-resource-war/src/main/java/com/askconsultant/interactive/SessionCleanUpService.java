package com.askconsultant.interactive;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ejb.TimerService;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class SessionCleanUpService {

	@Inject
	ChatSessionRegister chatRegister;
	
	@Resource 
	TimerService sessionCloseTimer;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Schedule(hour="*", minute="*/30", persistent=false)
	public void cleanUpClosedSessions() {
		logger.info("Cleaning up closed sessions");
		chatRegister.removeClosedSessions();
	}
	
}
