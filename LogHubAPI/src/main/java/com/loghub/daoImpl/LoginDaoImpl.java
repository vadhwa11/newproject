package com.loghub.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loghub.dao.LoginDao;
import com.loghub.dto.LoginDTO;
import com.loghub.dto.ResponseModel;
import com.loghub.extention.ConstantExtension;
import com.loghub.extention.HelperExtension;
import com.loghub.utils.JdbcConnectionUtil;

public class LoginDaoImpl implements LoginDao {
	
	ObjectMapper objectMapper;
	HelperExtension helperExtension = new HelperExtension();
	public ResponseModel getLogin(String userName, String password) {

		ResponseModel responseModel;
		JsonNode jsonNode = null;
		objectMapper = new ObjectMapper();
		LoginDTO dto = new LoginDTO();
		
		
		
  List<LoginDTO> loginDTO = new ArrayList<LoginDTO>();
	    try {
	    	PreparedStatement pstmt = null;
	    	System.out.println("User Name:: "+userName);
	    	System.out.println("Password:: "+password);      
	        
	        	String query = "select USER_NAME,pwd from LMS_USER_LOGIN where USER_NAME='"+userName+"' and pwd='"+password+"'";
				
	    		Connection con = JdbcConnectionUtil.getConnection();
	    		
	    		try {
	    			pstmt = con.prepareStatement(query);
	    			ResultSet rset = pstmt.executeQuery();
	    			while (rset.next()) {
	    				dto.setUserName(rset.getString(1));
	    				dto.setUserType(rset.getString(2));
	    				loginDTO.add(dto);
	    			}

	    		} catch (Exception e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}finally{
	    			if(con!=null){
	    				try {
	    					con.close();
	    				} catch (Exception e) {
	    					// TODO Auto-generated catch block
	    					e.printStackTrace();
	    				}
	    			}
	    			System.out.println("loginDTO size:: "+loginDTO.size());
				jsonNode=objectMapper.valueToTree(loginDTO);
				responseModel = new ResponseModel(true, ConstantExtension.SUCCESS_RECEIVE, jsonNode);
			}
			
	       
	    }catch(Exception e) {
			e.printStackTrace();
			responseModel = new ResponseModel(false, ConstantExtension.MESSAGE_ERROR, jsonNode);
		}
	    
		return responseModel;
	
	}
}
