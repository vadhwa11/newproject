package com.loghub.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loghub.dao.GetUomDao;
import com.loghub.dto.ResponseModel;
import com.loghub.dto.UomDTO;
import com.loghub.extention.ConstantExtension;
import com.loghub.extention.HelperExtension;
import com.loghub.utils.JdbcConnectionUtil;

public class GetUomDaoImpl implements GetUomDao {

	
		ObjectMapper objectMapper;
		HelperExtension helperExtension = new HelperExtension();
		
		public ResponseModel getUom() {
			
				ResponseModel responseModel;
				JsonNode jsonNode = null;
				objectMapper = new ObjectMapper();
				
			
		
		  List<UomDTO> uomDtoList = new ArrayList<UomDTO>();
			   
			        	String query = "select UOM_ID,UOM from LMS_UOM";
						
			    		Connection con = JdbcConnectionUtil.getConnection();
			    		Statement stmt = null;

			    		try {
			    			stmt = con.createStatement();

			    			ResultSet rset = stmt.executeQuery(query);
			    			while (rset.next()) {
			    				UomDTO uomDto = new UomDTO();
			    				uomDto.setUomId(rset.getString(1));
			    				uomDto.setUom(rset.getString(2));
			    				uomDtoList.add(uomDto);
			    			}

						jsonNode=objectMapper.valueToTree(uomDtoList);
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


