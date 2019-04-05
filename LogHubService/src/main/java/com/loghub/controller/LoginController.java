package com.loghub.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.loghub.dto.LoginDTO;
import com.loghub.dto.ResponseModel;
import com.loghub.extention.ResponseCreatorExtension;
import com.loghub.serviceImpl.LoginServiceImpl;


@Path("/login")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LoginController {
	
	/*@POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTrackInJSON(LoginDTO loginDTO) throws JsonProcessingException{
        System.out.println("inside post method . .");
        System.out.println(loginDTO.getUserName());
		System.out.println(loginDTO.getPassword());
        String result = "Track saved : " + loginDTO;
        ResponseModel responseModel = new LoginServiceImpl().getLogin(loginDTO.getUserName(), loginDTO.getPassword());
		return ResponseCreatorExtension.responseCreator(responseModel);

    }*/
	/*@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getLogin(LoginDTO loginDTO)
			throws JsonProcessingException {
		System.out.println("in controller");
		System.out.println(loginDTO.getUserName());
		System.out.println(loginDTO.getPassword());
		ResponseModel responseModel = new LoginServiceImpl().getLogin(loginDTO.getUserName(), loginDTO.getPassword());
		return ResponseCreatorExtension.responseCreator(responseModel);
	}*/
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
