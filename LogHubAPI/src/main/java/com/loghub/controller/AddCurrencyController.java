package com.loghub.controller;

import javax.annotation.PostConstruct;
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
import com.loghub.serviceImpl.AddCurrencyServiceImpl;
import com.loghub.serviceImpl.LoginServiceImpl;


@Path("/addCurrency")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AddCurrencyController {

	@PostConstruct
	public Response getCurrency(@QueryParam("currencyName") String currencyName, @QueryParam("currencyValue") String currencyValue)
			throws JsonProcessingException {
		
		System.out.println(currencyName);
		System.out.println(currencyValue);
		ResponseModel responseModel = new AddCurrencyServiceImpl().addCurrency(currencyName, currencyValue);
		return ResponseCreatorExtension.responseCreator(responseModel);
	}
	
	
	
}
