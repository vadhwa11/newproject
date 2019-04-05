package com.loghub.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loghub.dao.AddCurrencyDao;
import com.loghub.dto.CurrencyDTO;
import com.loghub.dto.LoginDTO;
import com.loghub.dto.ResponseModel;
import com.loghub.extention.ConstantExtension;
import com.loghub.extention.HelperExtension;
import com.loghub.utils.JdbcConnectionUtil;

public class AddCurrencyDaoImpl implements AddCurrencyDao {

	public ResponseModel addCurrency(String currencyName, String currencyValue) {
		ObjectMapper objectMapper;
		HelperExtension helperExtension = new HelperExtension();

		ResponseModel responseModel;
		JsonNode jsonNode = null;
		objectMapper = new ObjectMapper();
		CurrencyDTO dto = new CurrencyDTO();
		Connection con = JdbcConnectionUtil.getConnection();
		PreparedStatement psmt = null;
		CallableStatement callableStatement = null;
		int status = 0;
		ResultSet rset = null;
		String query = "insert into LMS_CODE_CURR (CUR,CUR_VALUE) values(?,?)";

		String addCurrency = "{call addCurrency(?,?)}";

		try {
			callableStatement = con.prepareCall(addCurrency);
			callableStatement.setString(1, currencyName);
			callableStatement.setString(2, currencyValue);

			status = callableStatement.executeUpdate();

			/*
			 * //insert into LMS_CODE_CURR (CUR,CUR_VALUE)
			 * values('curName','77'); /// List<AddCurrencyDTO> addCurrencyDTO =
			 * new ArrayList<AddCurrencyDTO>(); try {
			 * 
			 * psmt=con.prepareStatement(query); psmt.setString(1,
			 * currencyName); psmt.setString(2, currencyValue); status=
			 * psmt.executeUpdate();
			 */
			jsonNode = objectMapper.valueToTree(status);
			responseModel = new ResponseModel(true, ConstantExtension.SUCCESS_RECEIVE, jsonNode);

		}

		catch (Exception e) {

			e.printStackTrace();
			System.out.println(" e :: " + e);
			responseModel = new ResponseModel(false, ConstantExtension.MESSAGE_ERROR, jsonNode);
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(" psmt status :: " + status);

		return responseModel;

	}

	
	public List<String> duplicateCurrency() {


		ObjectMapper objectMapper;
		HelperExtension helperExtension = new HelperExtension();
		CurrencyDTO cd=new CurrencyDTO();
		List<String> currencydto=new ArrayList<String>();
			ResponseModel responseModel;
			JsonNode jsonNode = null;
			objectMapper = new ObjectMapper();
			CurrencyDTO dto = new CurrencyDTO();
			Connection con = JdbcConnectionUtil.getConnection();
			PreparedStatement psmt=null;
			CallableStatement callableStatement = null;
			int status=0;
			ResultSet rset=null;
			String query="select CUR  from LMS_CODE_CURR ";
			
try {
	          psmt = con.prepareStatement(query);
	          rset=psmt.executeQuery();
		 while(rset.next())
		 {
			 
			 String dupName = rset.getString(1);
			// cd.setCurrencyName(dupName);
			 currencydto.add(dupName);
			 }
			
	 }
	
	catch(Exception e){
		
		e.printStackTrace();
		System.out.println(" e :: "+e);
		//responseModel = new ResponseModel(false, ConstantExtension.MESSAGE_ERROR, jsonNode);
	}finally {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	System.out.println(" psmt status :: "+currencydto.size());
	 
	 return currencydto;
		
	}
}
