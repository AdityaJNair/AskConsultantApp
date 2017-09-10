package com.askconsultant.resource.converter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.askconsultant.common.ConversationHelper;
import com.askconsultant.common.FileUtil;
import com.askconsultant.model.Conversation;
import com.google.gson.JsonElement;

public class TestConversationJSONConverter {
	
	ConversationJSONConverter conversationJSONConverter;
	
	@Before
	public void init() {
		conversationJSONConverter = new ConversationJSONConverter();
	}
	
	
	/**
	 * Tests the convert method
	 */
	@Test
	public void convert() {
		String readJSONFile = FileUtil.readJSONFile("TEST1_CONVERSATION_REQUEST_JSON.json");
		try {
			Conversation convert = conversationJSONConverter.convert(readJSONFile);
			assertNotNull(convert);
			assertEquals("name",convert.getName());
			assertEquals("category",convert.getCategory());
		} catch (Exception e) {
			fail();
		}
		
	}
	
	/**
	 * Tests the conversion to JSON object
	 */
	@Test
	public void convertToJsonElement() {
		Conversation conversationWithAllValues = ConversationHelper.getConversationWithAllValues(1);
		JsonElement json = conversationJSONConverter.convertToJsonElement(conversationWithAllValues);
		assertNotNull(json);
		assertTrue(json.toString().contains("\"id\":1"));
	}

}
