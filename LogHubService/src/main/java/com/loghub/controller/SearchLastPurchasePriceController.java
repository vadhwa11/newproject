package com.loghub.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.loghub.dto.ResponseModel;
import com.loghub.extention.ResponseCreatorExtension;
import com.loghub.serviceImpl.SearchLastPurchasePriceServiceImpl;

@Path("/searchPurchasePrice")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SearchLastPurchasePriceController {
	
	@GET
	public Response searchLastPurchasePrice(@HeaderParam("partNo") String partNo) throws JsonProcessingException{
											//@HeaderParam("description") String description,
											//@HeaderParam("equipment") String equipment,
											//@HeaderParam("ledgerNo") String ledgerNo)throws JsonProcessingException{
		
		ResponseModel responseModel = new SearchLastPurchasePriceServiceImpl().getLastPurchasePrice(partNo);
		return ResponseCreatorExtension.responseCreator(responseModel);
	}
	
}
