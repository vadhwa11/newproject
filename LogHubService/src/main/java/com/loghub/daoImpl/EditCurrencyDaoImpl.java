package com.loghub.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loghub.dao.EditCurrencyDao;
import com.loghub.dto.CurrencyDTO;
import com.loghub.dto.ResponseModel;
import com.loghub.extention.ConstantExtension;
import com.loghub.extention.HelperExtension;
import com.loghub.utils.JdbcConnectionUtil;

public class EditCurrencyDaoImpl implements EditCurrencyDao {

	public ResponseModel editCurrency(String currencyName,String currencyValue) {
		System.out.println(" currency name in edit daoimpl ..  "+currencyName);
		
		ObjectMapper objectMapper;
		HelperExtension helperExtension = new HelperExtension();
		

			ResponseModel responseModel;
			JsonNode jsonNode = null;
			objectMapper = new ObjectMapper();
			CurrencyDTO dto = new CurrencyDTO();
			Connection con = JdbcConnectionUtil.getConnection();
			CallableStatement callableStatement = null;
			PreparedStatement psmt=null;
			int status=0;
			ResultSet rset=null;
			
            String updateCurrency = "{call updateCurrency(?,?)}";
			
			try {
				callableStatement = con.prepareCall(updateCurrency);
				callableStatement.setString(1, currencyValue);
				callableStatement.setString(2, currencyName);
				
				
				
				status= callableStatement.executeUpdate();
			
			
			/*String query="update LMS_CODE_CURR set CUR=?,CUR_VALUE=? where CUR='"+currencyNameForUpdate+"' ";
try {
				
				psmt=con.prepareStatement(query);
				System.out.println("query update :: "+query);
				psmt.setString(1, currencyName);
				psmt.setString(2, currencyValue);
			status=	psmt.executeUpdate();*/
				jsonNode=objectMapper.valueToTree(status);
				responseModel = new ResponseModel(true, ConstantExtension.SUCCESS_RECEIVE, jsonNode);
				
		 }
		catch(Exception e){
			e.printStackTrace();
			responseModel = new ResponseModel(false, ConstantExtension.MESSAGE_ERROR, jsonNode);
		}finally {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(" psmt status in edit:: "+status);
		 
		 return responseModel;
		
		
	}

	
	
}
