package com.loghub.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.loghub.dto.InventoryDTO;
import com.loghub.dto.ResponseModel;
import com.loghub.extention.ResponseCreatorExtension;
import com.loghub.serviceImpl.AddInventoryServiceImpl;

@Path("/addInventory")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AddInventoryController {
	
	@POST
	public Response addInventory(
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
		System.out.println("in controller");
	/*	System.out.println(userName);
		System.out.println(password);*/
		//ResponseModel responseModel = new AddInventoryServiceImpl().addInventory(userName, password);
		ResponseModel responseModel = new AddInventoryServiceImpl().addInventoryDetails(sku,uom,depot,icgQty,equipment,partNo,
				sPartNo,descr,ledgerNo,unitPrice,currency,cat,msl,xDept,skuFinal);
		//ResponseModel responseModel = new AddInventoryServiceImpl().addInventoryDetails(inventory);
		return ResponseCreatorExtension.responseCreator(responseModel);
	}
}
