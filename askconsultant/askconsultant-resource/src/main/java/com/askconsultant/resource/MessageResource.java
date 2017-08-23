package com.askconsultant.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.askconsultant.common.json.JsonWriter;
import com.askconsultant.model.Message;
import com.askconsultant.resource.converter.MessageJSONConverter;
import com.askconsultant.service.MessageService;

@Path("/chats")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Inject
	MessageService messageService;
	
	@Inject
	MessageJSONConverter messagejsonconverter;

	@POST
	public Response addMessage(final String json) throws Exception {
		logger.debug("Adding message");
		Message message = messagejsonconverter.convert(json);
		Message addMessage = messageService.addMessage(message);
		// add the response
		return Response.status(201).entity(JsonWriter.writeToString(addMessage)).build();
	}

	@GET
	public Response listMessages(final String json) throws Exception {
		logger.debug("Listing messages");
		List<Message> messages = messageService.listAllMessages();
		return Response.status(201)
				.entity(JsonWriter.writeToString(messagejsonconverter.convertToJsonElement(messages))).build();
	}

}
