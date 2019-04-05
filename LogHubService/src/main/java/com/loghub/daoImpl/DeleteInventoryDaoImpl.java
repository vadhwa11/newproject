package com.loghub.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loghub.dao.DeleteInventoryDao;
import com.loghub.dto.InventoryDTO;
import com.loghub.dto.ResponseModel;
import com.loghub.extention.ConstantExtension;
import com.loghub.extention.HelperExtension;
import com.loghub.utils.JdbcConnectionUtil;
import com.sun.mail.imap.protocol.Status;

public class DeleteInventoryDaoImpl implements DeleteInventoryDao{

	ObjectMapper objectMapper;
	HelperExtension helperExtension = new HelperExtension();
	private int status = 0;
	
	public ResponseModel deleteInventoryDetails(String sku) {
		

				ResponseModel responseModel;
				JsonNode jsonNode = null;
				objectMapper = new ObjectMapper();
			
			        	String query = "delete from LMS_SKU where SKU='" + sku + "'";
						
			    		Connection con = JdbcConnectionUtil.getConnection();
			    		PreparedStatement stmt = null;

			    		try {
			    			stmt = con.prepareStatement(query);

			    			status = stmt.executeUpdate();
			    			
						jsonNode=objectMapper.valueToTree(status);
						responseModel = new ResponseModel(true, ConstantExtension.SUCCESS_RECEIVE, jsonNode);
					
			       
			    }catch(Exception e) {
					e.printStackTrace();
					responseModel = new ResponseModel(false, ConstantExtension.MESSAGE_ERROR, jsonNode);
				}
			    		finally{
			    			if(con!=null){
			    				try {
			    					con.close();
			    				} catch (Exception e) {
			    					// TODO Auto-generated catch block
			    					e.printStackTrace();
			    				}
			    			}}
				return responseModel;
			
			}
		}


