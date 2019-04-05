package com.loghub.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loghub.dao.UpdateInventoryDao;
import com.loghub.dto.InventoryDTO;
import com.loghub.dto.ResponseModel;
import com.loghub.extention.ConstantExtension;
import com.loghub.extention.HelperExtension;
import com.loghub.utils.JdbcConnectionUtil;



public class UpdateInventoryDaoImpl implements UpdateInventoryDao{

	
		ObjectMapper objectMapper;
		HelperExtension helperExtension = new HelperExtension();
		private int status=0;
		
		public ResponseModel updateInventoryDetails(String skuForUpdate,String sku, String uom, String depot, String icgQty, String equitment,
				String partNo, String sPartNo, String descr, String ledgerNo, String unitPrice, String currency,
				String cat, String msl, String xDept, String skuFinal) {
			

				ResponseModel responseModel;
				JsonNode jsonNode = null;
				objectMapper = new ObjectMapper();
			
			        	
			        	String query = "update LMS_SKU set SKU=?,UOM=?,DEPOT=?,ICG_QTY=?,EQUIPMENT=?,PARTNO=?,"
			        			+ "S_PARTNO=?,DESCR=?,LEDGERNO=?,UNIT_PRICE=?,CUR=?,CAT=?,MSL=?,XDEPT=?,SKU_FINAL=? where SKU='" + skuForUpdate + "'"; 
			        			
						
			    		Connection con = JdbcConnectionUtil.getConnection();
			    		PreparedStatement stmt = null;

			    		try {
			    			stmt = con.prepareStatement(query);

			    			stmt.setString(1, sku);
			    			stmt.setString(2, uom);
			    			stmt.setString(3, depot);
			    			stmt.setString(4, icgQty);
			    			stmt.setString(5, equitment);
			    			stmt.setString(6, partNo);
			    			stmt.setString(7, sPartNo);
			    			stmt.setString(8, descr);
			    			stmt.setString(9, ledgerNo);
			    			stmt.setString(10, unitPrice);
			    			stmt.setString(11, currency);
			    			stmt.setString(12, cat);
			    			stmt.setString(13, msl);
			    			stmt.setString(14, xDept);
			    			stmt.setString(15, skuFinal);
			    		

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


