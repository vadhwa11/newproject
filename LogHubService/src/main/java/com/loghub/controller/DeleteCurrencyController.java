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
import com.loghub.serviceImpl.DeleteCurrencyServiceImpl;

@Path("/deleteCurrency")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DeleteCurrencyController {
	
	@GET
	public Response deleteCurrency(@QueryParam("currencyName") String currencyName)throws JsonProcessingException {
		
		ResponseModel responseModel = new DeleteCurrencyServiceImpl().deleteCurrency(currencyName);
		return ResponseCreatorExtension.responseCreator(responseModel);
	}

}
