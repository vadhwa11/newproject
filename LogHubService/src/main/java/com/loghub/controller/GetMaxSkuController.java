package com.loghub.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.loghub.dto.ResponseModel;
import com.loghub.extention.ResponseCreatorExtension;
import com.loghub.serviceImpl.GetMaxSkuServiceImpl;
import com.loghub.serviceImpl.GetUomServiceImpl;


@Path("/getMaxSku")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GetMaxSkuController {
	
	@GET
	public Response getMaxSku()
			throws JsonProcessingException {
		System.out.println("in controller");
		
		ResponseModel responseModel = new GetMaxSkuServiceImpl().getMaxSku();
		return ResponseCreatorExtension.responseCreator(responseModel);
	}
}
