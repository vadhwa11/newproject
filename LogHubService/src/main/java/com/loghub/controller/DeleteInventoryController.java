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
import com.loghub.serviceImpl.DeleteInventoryServiceImpl;

@Path("/deleteInventory")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DeleteInventoryController {
	
	@GET
	public Response deleteInventory(@HeaderParam("sku") String sku)
			throws JsonProcessingException {
		/*System.out.println("in controller");
		System.out.println(userName);
		System.out.println(password);*/
		ResponseModel responseModel = new DeleteInventoryServiceImpl().deleteInventoryDetails(sku);
		return ResponseCreatorExtension.responseCreator(responseModel);
	}
}
