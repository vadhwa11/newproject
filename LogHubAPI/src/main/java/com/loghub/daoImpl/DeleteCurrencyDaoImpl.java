package com.loghub.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loghub.dao.DeleteCurrencyDao;
import com.loghub.dto.Currency;
import com.loghub.dto.ResponseModel;
import com.loghub.extention.ConstantExtension;
import com.loghub.extention.HelperExtension;
import com.loghub.utils.JdbcConnectionUtil;

public class DeleteCurrencyDaoImpl implements DeleteCurrencyDao{

	public ResponseModel deleteCurrency(String currencyName) {
		
		ObjectMapper objectMapper;
		HelperExtension helperExtension = new HelperExtension();
		ResponseModel responseModel = null;
		JsonNode jsonNode = null;
		objectMapper = new ObjectMapper();
		
		Connection con = JdbcConnectionUtil.getConnection();
		
		
		
		try {
			String deleteCurrencyProcedure = "{call deleteCurrency(?)}";
		CallableStatement callableStatement = con.prepareCall(deleteCurrencyProcedure);
		callableStatement.setString(1, currencyName);
		
		int status = callableStatement.executeUpdate();
		System.out.println("API status :: "+status);
		if(status!=0) {
		jsonNode = objectMapper.valueToTree(status);
		responseModel = new ResponseModel(true, ConstantExtension.SUCCESS_RECEIVE, jsonNode);
		}else {
			jsonNode = objectMapper.valueToTree(status);
			responseModel = new ResponseModel(false, ConstantExtension.ERROR, jsonNode);
		}
		
		
		}catch(Exception e) {
			e.printStackTrace();
			responseModel = new ResponseModel(false, ConstantExtension.MESSAGE_ERROR, jsonNode);
		}
		
		return responseModel;
	}

}
