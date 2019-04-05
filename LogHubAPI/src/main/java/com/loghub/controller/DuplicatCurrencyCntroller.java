package com.loghub.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loghub.dto.ResponseModel;
import com.loghub.extention.ConstantExtension;
import com.loghub.extention.ResponseCreatorExtension;
import com.loghub.serviceImpl.AddCurrencyServiceImpl;



@Path("/duplicateCurrency")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DuplicatCurrencyCntroller {


		@GET
		public Response getCurrency(@QueryParam("currencyName") String currencyName)
				throws JsonProcessingException {
			JsonNode jsonNode = null;
			ResponseModel responseModel;
			ObjectMapper objectMapper = new ObjectMapper();
			System.out.println(currencyName);
			
			List<String> currencyNameList = new AddCurrencyServiceImpl().duplicateCurrencyName();
			
			if(currencyNameList.contains(currencyName)){
				String status="yes";
				jsonNode=objectMapper.valueToTree(status);
				responseModel = new ResponseModel(false, ConstantExtension.SUCCESS_RECEIVE, jsonNode);
				return ResponseCreatorExtension.responseCreator(responseModel);
			}
			
			
				String status="no";
			jsonNode=objectMapper.valueToTree(status);
			responseModel = new ResponseModel(true, ConstantExtension.MESSAGE_ERROR, jsonNode);
			return ResponseCreatorExtension.responseCreator(responseModel);
		
		
		}
		
	}
	
	


