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
import com.loghub.serviceImpl.SearchInventoryDetalisServiceImpl;

@Path("/searchInventoryDetails")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public class SearchInventoryDetalisController {
	@GET
		public Response getSearch(@QueryParam("partNo") String partNo, @QueryParam("desc") String desc,
				@QueryParam("depot") String depot)
				throws JsonProcessingException {
			ResponseModel responseModel = new SearchInventoryDetalisServiceImpl().getInventoryDetailsSearch(partNo, desc,depot);
			return ResponseCreatorExtension.responseCreator(responseModel);
		}
	}

		