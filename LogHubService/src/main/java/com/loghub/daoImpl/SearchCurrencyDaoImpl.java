package com.loghub.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loghub.extention.ConstantExtension;
import com.loghub.dao.SearchCurrencyDao;
import com.loghub.dto.ResponseModel;
import com.loghub.dto.CurrencyDTO;
import com.loghub.extention.HelperExtension;
import com.loghub.utils.JdbcConnectionUtil;

public class SearchCurrencyDaoImpl implements SearchCurrencyDao{

	ObjectMapper objectMapper;
	HelperExtension helperExtension = new HelperExtension();
	
	//@Override
	public ResponseModel getCurrencyList(String currencyName, String currencyValue) {
		
		ResponseModel responseModel = null;
		JsonNode jsonNode = null;
		objectMapper = new ObjectMapper();
		
		CurrencyDTO dto = new CurrencyDTO();
		
		Connection connection = JdbcConnectionUtil.getConnection();
		PreparedStatement stmt = null;
		ResultSet rset = null;
		
		List<CurrencyDTO> list = new ArrayList<CurrencyDTO>();
		
		if(currencyName!=null && !currencyName.equalsIgnoreCase("") && currencyValue == null) {
		
		try {
			
			String searchCurrencyQuery = "select * from LMS_CODE_CURR where lower(cur) like '%"+currencyName.toLowerCase() +"%'";
			stmt = connection.prepareStatement(searchCurrencyQuery);
	   		rset=stmt.executeQuery();
	   		while(rset.next()) {
	   			CurrencyDTO currencyDTO = new CurrencyDTO();
	   			currencyDTO.setCurrencyName(rset.getString(1));
	   			currencyDTO.setCurrencyValue(rset.getString(2));
	   			list.add(currencyDTO);
	   		}
	   		
	   		jsonNode = objectMapper.valueToTree(list);
			responseModel = new ResponseModel(true, ConstantExtension.SUCCESS_RECEIVE, jsonNode);
			
		}catch(Exception e) {
			e.printStackTrace();
			responseModel = new ResponseModel(false, ConstantExtension.MESSAGE_ERROR, jsonNode);
		}
		
	} else if(currencyValue!=null && !currencyValue.equalsIgnoreCase("") && currencyName == null) {
		try {
			
			String searchCurrencyQuery1 = "select * from LMS_CODE_CURR where cur_value = '"+currencyValue +"'";
			PreparedStatement stmt1 = null;
			ResultSet rset1 = null;
			
			stmt1 = connection.prepareStatement(searchCurrencyQuery1);
	   		rset1=stmt1.executeQuery();
	   		while(rset1.next()) {
	   			CurrencyDTO currencyDTO = new CurrencyDTO();
	   			currencyDTO.setCurrencyName(rset1.getString(1));
	   			currencyDTO.setCurrencyValue(rset1.getString(2));
	   			list.add(currencyDTO);
	   		}
	   		jsonNode = objectMapper.valueToTree(list);
			responseModel = new ResponseModel(true, ConstantExtension.SUCCESS_RECEIVE, jsonNode);
			
		}catch(Exception e) {
			e.printStackTrace();
			responseModel = new ResponseModel(false, ConstantExtension.ERROR, jsonNode);
		
		}
	}else if(currencyName!= null && currencyValue!=null) {
		try {
			String searchCurrencyQuery2 = "select * from LMS_CODE_CURR where lower(cur) = '"+currencyName.toLowerCase()+"' and  cur_value = '"+currencyValue +"'";
			PreparedStatement stmt2 = null;
			ResultSet rset2 = null;
			
			stmt2 = connection.prepareStatement(searchCurrencyQuery2);
	   		rset2=stmt2.executeQuery();
	   		while(rset2.next()) {
	   			CurrencyDTO currencyDTO = new CurrencyDTO();
	   			currencyDTO.setCurrencyName(rset2.getString(1));
	   			currencyDTO.setCurrencyValue(rset2.getString(2));
	   			list.add(currencyDTO);
	   		}
	   		jsonNode = objectMapper.valueToTree(list);
			responseModel = new ResponseModel(true, ConstantExtension.SUCCESS_RECEIVE, jsonNode);
		}catch(Exception e) {
			e.printStackTrace();
			responseModel = new ResponseModel(false, ConstantExtension.ERROR, jsonNode);
		}finally {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	else if(currencyName == null  && currencyValue == null){
		responseModel = new ResponseModel(false, ConstantExtension.ERROR, jsonNode);
	}
		
		
		return responseModel;
	}

}
