package com.loghub.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.loghub.dto.ResponseModel;
import com.loghub.extention.ResponseCreatorExtension;
import com.loghub.serviceImpl.UpdateInventoryServiceImpl;

@Path("/updateInventory")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UpdateInventoryController {
	
	
	@POST
	public Response updateInventory(
			@QueryParam("skuForUpdate") String skuForUpdate,
			@QueryParam("sku") String sku,
			@QueryParam("uom") String uom,
			@QueryParam("depot") String depot,
			@QueryParam("icgQty") String icgQty,
			@QueryParam("equipment") String equipment,
			@QueryParam("partNo") String partNo,
			@QueryParam("sPartNo") String sPartNo,
			@QueryParam("descr") String descr,
			@QueryParam("ledgerNo") String ledgerNo,
			@QueryParam("unitPrice") String unitPrice,
			@QueryParam("currency") String currency,
			@QueryParam("cat") String cat,
			@QueryParam("msl") String msl,
			@QueryParam("xDept") String xDept,
			@QueryParam("skuFinal") String skuFinal
			)
			throws JsonProcessingException {
		System.out.println("in controller inv update");
		System.out.println(equipment);
		System.out.println(partNo);
		//ResponseModel responseModel = new AddInventoryServiceImpl().addInventory(userName, password);
		ResponseModel responseModel = new UpdateInventoryServiceImpl().updateInventoryDetails(skuForUpdate,sku,uom,depot,icgQty,equipment,partNo,
				sPartNo,descr,ledgerNo,unitPrice,currency,cat,msl,xDept,skuFinal);
		return ResponseCreatorExtension.responseCreator(responseModel);
	}
}
