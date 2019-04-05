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


@Path("/loginRest")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LoginControllerUsingSpringRest {
	
	@POST
	public Response getLogin(@QueryParam("userName") String userName, @QueryParam("password") String password)
			throws JsonProcessingException {
		System.out.println("in controller");
		System.out.println(userName);
		System.out.println(password);
		ResponseModel responseModel = new LoginServiceImpl().getLogin(userName, password);
		return ResponseCreatorExtension.responseCreator(responseModel);
	}
}
