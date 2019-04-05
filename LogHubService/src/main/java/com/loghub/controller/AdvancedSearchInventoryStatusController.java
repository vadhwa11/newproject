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
import com.loghub.serviceImpl.AdvancedSearchInventoryStatusServiceImpl;

@Path("/advancedSearchInventoryStatus")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AdvancedSearchInventoryStatusController {
	
	@GET
	public Response getSearch(@QueryParam("advancePartNo") String advancePartNo, 
			@QueryParam("advDescr") String advDescr,
			@QueryParam("partRadio") String partRadio)
			throws JsonProcessingException {
		System.out.println("in advance search controller");
		ResponseModel responseModel = new AdvancedSearchInventoryStatusServiceImpl().getAdvancedInventoryStatusSearch(advancePartNo, advDescr, partRadio);
		return ResponseCreatorExtension.responseCreator(responseModel);
	}

}
