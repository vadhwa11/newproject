package com.loghub.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.loghub.dto.ResponseModel;
import com.loghub.extention.ResponseCreatorExtension;
import com.loghub.serviceImpl.SearchInventoryServiceImpl;

@Path("/searchInventory")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SearchInventoryController {
	
	@GET
	public Response searchInventory(@QueryParam("sku") String sku)
			throws JsonProcessingException {
		/*System.out.println("in controller");
		System.out.println(userName);
		System.out.println(password);*/
		ResponseModel responseModel = new SearchInventoryServiceImpl().getInventoryDetails(sku);
		return ResponseCreatorExtension.responseCreator(responseModel);
	}
}
