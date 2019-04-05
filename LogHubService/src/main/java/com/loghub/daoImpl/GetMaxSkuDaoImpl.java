package com.loghub.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loghub.dao.GetMaxSkuDao;
import com.loghub.dto.DepotDTO;
import com.loghub.dto.ResponseModel;
import com.loghub.extention.ConstantExtension;
import com.loghub.extention.HelperExtension;
import com.loghub.utils.JdbcConnectionUtil;

public class GetMaxSkuDaoImpl implements GetMaxSkuDao {

	
		
		ObjectMapper objectMapper;
		HelperExtension helperExtension = new HelperExtension();
		
		public ResponseModel getMaxSku() {
			
			

				ResponseModel responseModel;
				JsonNode jsonNode = null;
				objectMapper = new ObjectMapper();
				
			
			   
			        	String query = "select 'S'||to_char(sku.nextval,'FM0000000')from dual";
				   /* String query="select max(substr(sku,2,7)) from lms_sku";*/
			    		Connection con = JdbcConnectionUtil.getConnection();
			    		Statement stmt = null;

			    		try {
			    			stmt = con.createStatement();

			    			ResultSet rset = stmt.executeQuery(query);
			    			String sku="";
			    			while (rset.next()) {
			    				sku=rset.getString(1);
			    				//sku="S"+(currentSku+1);
			    				
			    			
			    			}
			    			System.out.println(sku);
                      /*  int sku_num=Integer.parseInt(sku)+1;
                        
                        String numberAsString = "S"+String.format ("%07d", sku_num);*/
                        //System.out.println("numberAsString"+numberAsString);
                     
						jsonNode=objectMapper.valueToTree(sku);
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
