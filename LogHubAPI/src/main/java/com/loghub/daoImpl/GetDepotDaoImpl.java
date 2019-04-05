package com.loghub.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loghub.dao.GetDepotDao;
import com.loghub.dto.DepotDTO;
import com.loghub.dto.ResponseModel;
import com.loghub.extention.ConstantExtension;
import com.loghub.extention.HelperExtension;
import com.loghub.utils.JdbcConnectionUtil;

public class GetDepotDaoImpl implements GetDepotDao {

	
		ObjectMapper objectMapper;
		HelperExtension helperExtension = new HelperExtension();
		
		public ResponseModel getDepot() {
			
			

				ResponseModel responseModel;
				JsonNode jsonNode = null;
				objectMapper = new ObjectMapper();
				
			
		
		  List<DepotDTO> depotDtoList = new ArrayList<DepotDTO>();
			   
			        	String query = "select DEPO_ID,DEPOT_NAME from LMS_DEPOT";
						
			    		Connection con = JdbcConnectionUtil.getConnection();
			    		Statement stmt = null;

			    		try {
			    			stmt = con.createStatement();

			    			ResultSet rset = stmt.executeQuery(query);
			    			while (rset.next()) {
			    				DepotDTO depotDto = new DepotDTO();
			    				depotDto.setDepotId(rset.getString(1));
			    				depotDto.setDepotName(rset.getString(2));
			    				depotDtoList.add(depotDto);
			    			}

						jsonNode=objectMapper.valueToTree(depotDtoList);
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


