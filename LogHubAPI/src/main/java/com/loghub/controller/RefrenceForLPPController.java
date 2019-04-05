package com.loghub.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.loghub.dto.ResponseModel;
import com.loghub.extention.ResponseCreatorExtension;
import com.loghub.serviceImpl.RefrenceForLPPServiceImpl;

@Path("/refForLPP")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RefrenceForLPPController {
	
	@GET
	public Response refrenceForLPP(@QueryParam("sku") String sku) throws JsonProcessingException{
											
		
		ResponseModel responseModel = new RefrenceForLPPServiceImpl().gerRefForLPP(sku);
		return ResponseCreatorExtension.responseCreator(responseModel);
	}
	

}
