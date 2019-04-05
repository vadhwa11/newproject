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
import com.loghub.serviceImpl.NacServiceImpl;

@Path("/nac")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class NACController {

	@GET
	public Response getNacDetails(@QueryParam("partNo") String partNo,
			@QueryParam("depot") String depot,
			@QueryParam("fromDate") String fromDate,
			@QueryParam("toDate") String toDate) throws JsonProcessingException{
											
		System.out.println("ïn nac controlle:: " +partNo);
		System.out.println("ïn nac controlle depot:: " +depot);
		System.out.println("ïn nac controlle fromDate :: " +fromDate);
		System.out.println("ïn nac controlle toDate:: " +toDate);
		ResponseModel responseModel = new NacServiceImpl().getNacDetails(partNo, depot, fromDate, toDate);
		return ResponseCreatorExtension.responseCreator(responseModel);
	}
}
