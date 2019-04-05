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
/*public Response getSearch(@HeaderParam("partNo") String partNo, @HeaderParam("desc") String desc,
		@HeaderParam("depot") String depot, @HeaderParam("sku") String sku, @HeaderParam("equipment") String equipment, 
		@HeaderParam("ledgerNo") String ledgerNo, @HeaderParam("advancePartNo") String advancePartNo)
		throws JsonProcessingException {
	ResponseModel responseModel = new SearchInventoryStatusServiceImpl().getInventoryStatusSearch(partNo, desc,depot,sku,equipment,ledgerNo,advancePartNo);
	return ResponseCreatorExtension.responseCreator(responseModel);
	}*/

public Response getSearch(@QueryParam("partNo") String partNo, @QueryParam("desc") String desc,
		@QueryParam("depot") String depot, @QueryParam("sku") String sku, @QueryParam("equipment") String equipment, 
		@QueryParam("ledgerNo") String ledgerNo, @QueryParam("advancePartNo") String advancePartNo)
		throws JsonProcessingException {
	ResponseModel responseModel = new SearchInventoryStatusServiceImpl().getInventoryStatusSearch(partNo, desc,depot,sku,equipment,ledgerNo, advancePartNo);
	return ResponseCreatorExtension.responseCreator(responseModel);
	}
}

	
