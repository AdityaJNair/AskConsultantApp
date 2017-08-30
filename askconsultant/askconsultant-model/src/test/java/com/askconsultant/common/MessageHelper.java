package com.askconsultant.common;

import java.sql.Date;
import java.time.LocalDate;

import com.askconsultant.model.Message;

public class MessageHelper {

	public static Message legalSmithNow(){
		
		Message message = new Message("Legal", "This is how", "Smith", Date.valueOf(LocalDate.now()));
		return message;
		
	}
	
	public static Message legalNewUserYesterday(){
		
		Message message = new Message("Legal", "How is this done?", "Smith", Date.valueOf(LocalDate.now().minusDays(1)));
		return message;
		
	}
}
