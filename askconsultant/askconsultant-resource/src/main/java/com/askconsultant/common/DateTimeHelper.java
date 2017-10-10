package com.askconsultant.common;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * DateTime helper class for formatting date and time
 *
 */
public class DateTimeHelper {

	static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
	static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MMM-uuuu");
	static String zoneID="Pacific/Auckland";
	
	public static String dateTimeFormatter(Timestamp timestamp) {
		String formattedDateTime = "";
		try {
			formattedDateTime = "";
			ZoneId zone = ZoneId.of(zoneID);
			//TODO: Remove the plusHours, ideally the server code should work on UTC time and the clients
			//will format
			ZonedDateTime messageDateTime = timestamp.toLocalDateTime().atZone(zone).plusHours(13);
			ZonedDateTime now = LocalDateTime.now().atZone(zone).plusHours(13);
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
	
	public static void main(String[] args) {
		Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now().minusHours(13));
		String dateTimeFormatter = DateTimeHelper.dateTimeFormatter(timestamp);
		System.out.println(dateTimeFormatter);
	}
}
