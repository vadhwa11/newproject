package com.loghub.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.LoginException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loghub.dao.LoginDao;
import com.loghub.dto.LoginDTO;
import com.loghub.dto.ResponseModel;
import com.loghub.extention.ConstantExtension;
import com.loghub.extention.HelperExtension;
import com.loghub.utils.ActiveDirectoryAuthentication;
import com.loghub.utils.JdbcConnectionUtil;

public class LoginDaoImpl implements LoginDao {
	
	ObjectMapper objectMapper;
	HelperExtension helperExtension = new HelperExtension();
	public ResponseModel getLogin(String userName, String password) {

		ResponseModel responseModel;
		JsonNode jsonNode = null;
		objectMapper = new ObjectMapper();
		LoginDTO dto = new LoginDTO();
		
		/*LoginDao dao = new LoginDao();
		try {
			List<LoginDTO> loginDTO = new ArrayList<>();
			List<Login> loginDaos = dao.findAll();
			for(Login login: loginDaos) {
				dto = new DTOSetterExtension().getLoginDTO(login);
				loginDTO.add(dto);
			}*/
		
ActiveDirectoryAuthentication authentication = new ActiveDirectoryAuthentication("chakra.icg");
  List<LoginDTO> loginDTO = new ArrayList<LoginDTO>();
	    try {
	    	System.out.println("User Name:: "+userName);
	    	System.out.println("Password:: "+password);
	        boolean authResult = authentication.authenticate(userName,password);
	        System.out.println("Auth: " + authResult);
	        
	     // boolean authResult =true;
	        
	        if(authResult){
	        	String query = "select USER_NAME,USER_TYPE,ORG_UNIT from LMS_USER_LOGIN where USER_Id='" + userName + "'";
				
	    		Connection con = JdbcConnectionUtil.getConnection();
	    		Statement stmt = null;

	    		try {
	    			stmt = con.createStatement();

	    			ResultSet rset = stmt.executeQuery(query);
	    			while (rset.next()) {
	    				dto.setUserName(rset.getString(1));
	    				dto.setUserType(rset.getString(2));
	    				dto.setOrgUnit(rset.getString(3));
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
	        	//dto.setUserName(userName);
	        	//loginDTO.add(dto);
				jsonNode=objectMapper.valueToTree(loginDTO);
				responseModel = new ResponseModel(true, ConstantExtension.SUCCESS_RECEIVE, jsonNode);
			}}
			else
			{
				responseModel = new ResponseModel(false, ConstantExtension.LOGIN_MESSAGE_ERROR, jsonNode);
			}
	       
	    }catch(Exception e) {
			e.printStackTrace();
			responseModel = new ResponseModel(false, ConstantExtension.MESSAGE_ERROR, jsonNode);
		}
	    
		return responseModel;
	
	}
}
