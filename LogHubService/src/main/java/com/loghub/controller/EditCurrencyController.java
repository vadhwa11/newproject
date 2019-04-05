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
import com.loghub.serviceImpl.AddCurrencyServiceImpl;
import com.loghub.serviceImpl.EditCurrencyServiceImpl;



@Path("/editCurrency")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EditCurrencyController {

		@POST
		public Response editCurrency(@QueryParam("currencyName") String currencyName, @QueryParam("currencyValue") String currencyValue)
				throws JsonProcessingException {
			System.out.println("in edit Currency Controller");
			System.out.println(currencyName);
			System.out.println(currencyValue);
			ResponseModel responseModel = new EditCurrencyServiceImpl().editCurrency(currencyName,currencyValue);
			return ResponseCreatorExtension.responseCreator(responseModel);
		}
	
}
