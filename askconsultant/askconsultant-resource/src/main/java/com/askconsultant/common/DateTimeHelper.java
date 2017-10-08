package com.askconsultant.common;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeHelper {

	static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
	static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MMM-uuuu");
	
	public static String dateTimeFormatter(Timestamp timestamp) {
		String formattedDateTime = "";
		try {
			formattedDateTime = "";
			LocalDateTime messageDateTime = timestamp.toLocalDateTime();
			LocalDateTime now = LocalDateTime.now();
			// if today is the same as the day the message was sent then set the display
			// time only
			if (messageDateTime.getDayOfMonth() == now.getDayOfMonth()) {
				formattedDateTime = messageDateTime.format(timeFormatter).toString();
			} else {
				formattedDateTime = messageDateTime.format(dateFormatter).toString().concat(" ").concat("at ")
						.concat(messageDateTime.format(timeFormatter).toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return formattedDateTime;
	}
}