package com.askconsultant.resource.converter;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.askconsultant.common.FileUtil;
import com.askconsultant.common.MessageHelper;
import com.askconsultant.model.Message;
import com.google.gson.JsonElement;

/**
 * This test class tests the MessageJSONConverter class that converts 
 * Message object to JSON and vice-versa.
 *
 */
public class TestMessageJSONConverter {

	MessageJSONConverter messageJSONConverter;

	@Before
	public void init() {
		messageJSONConverter = new MessageJSONConverter();
	}

	/**
	 * Test the method that creates a Message object from the JSON
	 */
	@Test
	public void convert() {
		try {
			String requestFile = FileUtil.readJSONFile("TEST1_MESSAGE_REQUEST_JSON.json");
			Message message = messageJSONConverter.convert(requestFile);
			assertNotNull(message);
			assertTrue(message.getMessage().length() != 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * Test the method that converts a Message object to JSON
	 */
	@Test
	public void convertToJsonElement() {
		try {
			Message testNeMessageObj = MessageHelper.getMessageWithValues(1l, "sender", 1l, "message");
			JsonElement convertToJsonElement = messageJSONConverter.convertToJsonElement(testNeMessageObj);
			assertNotNull(convertToJsonElement);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	/**
	 * Test the method that converts a Message object to JSON
	 */
	@Test
	public void convertListToJsonElement() {
		try {
			List<Message> listOfMessagesForConversation = MessageHelper.getListOfMessagesForConversation(1);
			JsonElement convertToJsonElement = messageJSONConverter.convertToJsonElement(listOfMessagesForConversation);
			assertNotNull(convertToJsonElement);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
