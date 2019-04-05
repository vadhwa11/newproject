package com.loghub.extention;

import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loghub.dto.ResponseModel;

public class ResponseCreatorExtension {
	public static Response responseCreator(ResponseModel responseModel) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return Response.status(Response.Status.OK)
				.entity(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(responseModel)).build();
	}
}
