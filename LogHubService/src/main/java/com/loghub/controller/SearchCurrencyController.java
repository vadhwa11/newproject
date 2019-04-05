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
import com.loghub.serviceImpl.SearchCurrencyServiceImpl;

@Path("/searchcurrency")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SearchCurrencyController {
	
	@GET
	public Response searchCurrency(@QueryParam("currencyName") String currencyName, @QueryParam("currencyValue") String currencyValue) throws JsonProcessingException{
		
		ResponseModel responseModel = new SearchCurrencyServiceImpl().getCurrencyList(currencyName, currencyValue);
		return ResponseCreatorExtension.responseCreator(responseModel);
	}

}
