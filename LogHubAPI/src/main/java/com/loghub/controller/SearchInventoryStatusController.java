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
import com.loghub.serviceImpl.SearchInventoryStatusServiceImpl;


@Path("/searchInventoryStatus")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SearchInventoryStatusController {
@GET
	public Response getSearch(@QueryParam("partNo") String partNo, @QueryParam("secondPartNo") String secondPartNo, @QueryParam("desc") String desc,
			@QueryParam("depot") String depot,@QueryParam("equipment") String equipment)
			throws JsonProcessingException {
		ResponseModel responseModel = new SearchInventoryStatusServiceImpl().getInventoryStatusSearch(partNo, secondPartNo, desc,depot,equipment);
		return ResponseCreatorExtension.responseCreator(responseModel);
	}
}

	
