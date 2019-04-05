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
import com.loghub.serviceImpl.SearchInventoryLppServiceImpl;


@Path("/searchInventoryLpp")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SearchInventoryLppController {
@GET
	public Response getSearch(@QueryParam("partNo") String partNo, @QueryParam("desc") String desc,
			@QueryParam("equipment") String equipment, @QueryParam("ledgerNo") String ledgerNo)
			throws JsonProcessingException {
		ResponseModel responseModel = new SearchInventoryLppServiceImpl().getInventoryLppSearch(partNo, desc,equipment,ledgerNo);
		return ResponseCreatorExtension.responseCreator(responseModel);
	}
}

	
