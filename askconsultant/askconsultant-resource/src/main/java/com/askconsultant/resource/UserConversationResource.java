package com.askconsultant.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.askconsultant.common.ResourceConstants;
import com.askconsultant.common.json.JsonWriter;
import com.askconsultant.model.Conversation;
import com.askconsultant.model.Message;
import com.askconsultant.resource.converter.ConversationJSONConverter;
import com.askconsultant.resource.converter.EmployeeCategoriesConverter;
import com.askconsultant.resource.converter.MessageJSONConverter;
import com.askconsultant.resource.converter.OperationFailureJSONConvertor;
import com.askconsultant.service.AuthenticationService;
import com.askconsultant.service.ConversationService;
import com.askconsultant.service.EmployeeService;
import com.askconsultant.service.MessageService;
import com.askconsultant.service.dto.ConversationWithLatestMessageDTO;

/**
 * Contains methods for processing conversations
 *
 */
@Path("users/{userid}/conversation")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserConversationResource {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Inject
	ConversationService conversationService;

	@Inject
	MessageService messageService;

	@Inject
	ConversationJSONConverter conversationJSONConverter;

	@Inject
	MessageJSONConverter messageJSONConverter;

	@Inject
	AuthenticationService authService;

	@Inject
	OperationFailureJSONConvertor opFailureJSONConverter;

	@Inject
	EmployeeService employeeService;

	@Inject
	EmployeeCategoriesConverter employeeTopicsConverter;

	/**
	 * Creates the conversation for a user
	 * 
	 * @param userId
	 * @param json
	 * @return
	 * @throws Exception
	 */
	@POST
	public Response addConversation(@PathParam("userid") String userId, final String json) throws Exception {
		logger.debug("Adding conversation");
		Conversation addedConversation;
		try {
			Conversation conversation = conversationJSONConverter.convert(json);
			// set the user id to be the owner of the creator
			conversation.setOwner(userId);
			addedConversation = conversationService.addConversation(conversation);
			return Response.status(201)
					.entity(JsonWriter.writeToString(conversationJSONConverter.convertToJsonElement(addedConversation)))
					.build();
		} catch (Exception e) {
			return Response.status(ResourceConstants.HTTP_RESPONSE_GENERIC_ERROR)
					.entity(JsonWriter.writeToString(opFailureJSONConverter.convertToJsonElement(e.getMessage())))
					.build();
		}

	}

	/**
	 * Lists all conversations, if the userid is an employee, then all conversations
	 * are listed, else only the conversations created by the user will be returned
	 * 
	 * @param userid
	 * @return
	 */
	@GET
	public Response listAllConversations(@PathParam("userid") String userid) {
		try {
			List<ConversationWithLatestMessageDTO> listActiveConversations = conversationService
					.listActiveConversationsForUser(userid);
			return Response.status(201)
					.entity(JsonWriter
							.writeToString(conversationJSONConverter.convertToJsonElement(listActiveConversations)))
					.build();
		} catch (Exception e) {
			return Response.status(ResourceConstants.HTTP_RESPONSE_GENERIC_ERROR)
					.entity(JsonWriter.writeToString(opFailureJSONConverter.convertToJsonElement(e.getMessage())))
					.build();
		}
	}

	/**
	 * Retrieves conversation details for a specific conversation id
	 * 
	 * @param conversationid
	 * @param userId
	 * @return
	 */
	@GET
	@Path("{conversationid}")
	public Response getConversation(@PathParam("conversationid") long conversationid,
			@PathParam("userid") String userId) {
		try {
			Conversation conversation = conversationService.getConversation(conversationid);
			return Response.status(201)
					.entity(JsonWriter.writeToString(conversationJSONConverter.convertToJsonElement(conversation)))
					.build();
		} catch (Exception e) {
			return Response.status(ResourceConstants.HTTP_RESPONSE_GENERIC_ERROR)
					.entity(JsonWriter.writeToString(opFailureJSONConverter.convertToJsonElement("Object not found")))
					.build();

		}
	}

	/**
	 * Lists all messages for a given conversation id
	 * 
	 * @param conversationid
	 * @return
	 */
	@GET
	@Path("{conversationid}/messages")
	public Response listMessagesForConversation(@PathParam("conversationid") long conversationid) {
		try {
			List<Message> listMessagesForConversation = messageService.listMessagesForConversation(conversationid);
			return Response.status(201)
					.entity(JsonWriter
							.writeToString(messageJSONConverter.convertToJsonElement(listMessagesForConversation)))
					.build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(ResourceConstants.HTTP_RESPONSE_GENERIC_ERROR)
					.entity(JsonWriter.writeToString(opFailureJSONConverter.convertToJsonElement("Object not found")))
					.build();
		}
	}

	@POST
	@Path("{conversationid}/message")
	public Response addMessage(@PathParam("conversationid") long conversationid, @PathParam("userid") String userid,
			final String json) {
		Message message;
		try {
			message = messageJSONConverter.convert(json);
			message.setConversation(conversationid);
			message.setSender(userid);
			Message addMessage = messageService.addMessage(message);
			return Response.status(201)
					.entity(JsonWriter.writeToString(messageJSONConverter.convertToJsonElement(addMessage))).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(ResourceConstants.HTTP_RESPONSE_GENERIC_ERROR)
					.entity(JsonWriter.writeToString(opFailureJSONConverter.convertToJsonElement(e.getMessage())))
					.build();
		}

	}

}
