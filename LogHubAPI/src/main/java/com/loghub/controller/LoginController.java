package com.loghub.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.loghub.dto.ResponseModel;
import com.loghub.extention.ResponseCreatorExtension;
import com.loghub.serviceImpl.LoginServiceImpl;


@Path("/login")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LoginController {
	
	@POST
	public Response getLogin(@HeaderParam("userName") String userName, @HeaderParam("password") String password)
			throws JsonProcessingException {
		ResponseModel responseModel = new LoginServiceImpl().getLogin(userName, password);
		return ResponseCreatorExtension.responseCreator(responseModel);
	}
}
