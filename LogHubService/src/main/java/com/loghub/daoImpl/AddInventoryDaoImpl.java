package com.loghub.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loghub.dao.AddInventoryDao;
import com.loghub.dto.InventoryDTO;
import com.loghub.dto.ResponseModel;
import com.loghub.extention.ConstantExtension;
import com.loghub.extention.HelperExtension;
import com.loghub.utils.JdbcConnectionUtil;

public class AddInventoryDaoImpl implements AddInventoryDao{

	
		ObjectMapper objectMapper;
		HelperExtension helperExtension = new HelperExtension();
		private int status=0;
		
		public ResponseModel addInventoryDetails(String sku, String uom, String depot, String icgQty, String equitment,
				String partNo, String sPartNo, String descr, String ledgerNo, String unitPrice, String currency,
				String cat, String msl, String xDept, String skuFinal) {
			
			

				ResponseModel responseModel;
				JsonNode jsonNode = null;
				objectMapper = new ObjectMapper();
				
				//check duplicate...
				String skuResult="";
				Connection con = null;
				
				
				try {
					
				con = JdbcConnectionUtil.getConnection();
				String querySelect = "select sku from LMS_SKU where SKU='"+sku+"'";
				PreparedStatement pstmt = con.prepareStatement(querySelect);
				ResultSet rset =  pstmt.executeQuery();
				
				while(rset.next()) {
					skuResult = rset.getString(1);
					System.out.println("skuResult :: "+skuResult);
					
				}
					
				if(skuResult.equalsIgnoreCase(sku)) {
					jsonNode=objectMapper.valueToTree(2);
						responseModel = new ResponseModel(true, ConstantExtension.DUPLICATE_MESSAGE, jsonNode);
					}else {
						String query = "insert into LMS_SKU"
			        			+"(SKU,UOM,DEPOT,ICG_QTY,EQUIPMENT,PARTNO,S_PARTNO,DESCR,LEDGERNO,UNIT_PRICE,"
			        			+ "CUR,CAT,MSL,XDEPT,SKU_FINAL)"
			        			+ "values" + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
						
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
						
					}
				
				/*String query = "insert into LMS_SKU"
	        			+"(SKU,UOM,DEPOT,ICG_QTY,EQUIPMENT,PARTNO,S_PARTNO,DESCR,LEDGERNO,UNIT_PRICE,"
	        			+ "CUR,CAT,MSL,XDEPT,SKU_FINAL)"
	        			+ "values" + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
				responseModel = new ResponseModel(true, ConstantExtension.SUCCESS_RECEIVE, jsonNode);*/
			
	       
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

		public ResponseModel addInventoryDetails(InventoryDTO inventory) {
			ResponseModel responseModel;
			JsonNode jsonNode = null;
			objectMapper = new ObjectMapper();
			
			//check duplicate...
			String skuResult="";
			Connection con = null;
			
			
			try {
				
			con = JdbcConnectionUtil.getConnection();
			String querySelect = "select sku from LMS_SKU where SKU='"+inventory.getSku()+"'";
			PreparedStatement pstmt = con.prepareStatement(querySelect);
			ResultSet rset =  pstmt.executeQuery();
			
			while(rset.next()) {
				skuResult = rset.getString(1);
				System.out.println("skuResult :: "+skuResult);
				
			}
				
			if(skuResult.equalsIgnoreCase(inventory.getSku())) {
				jsonNode=objectMapper.valueToTree(2);
					responseModel = new ResponseModel(true, ConstantExtension.DUPLICATE_MESSAGE, jsonNode);
				}else {
					String query = "insert into LMS_SKU"
		        			+"(SKU,UOM,DEPOT,ICG_QTY,EQUIPMENT,PARTNO,S_PARTNO,DESCR,LEDGERNO,UNIT_PRICE,"
		        			+ "CUR,CAT,MSL,XDEPT,SKU_FINAL)"
		        			+ "values" + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					
					PreparedStatement stmt = null;
					try {
		    			stmt = con.prepareStatement(query);

		    			stmt.setString(1, inventory.getSku());
		    			stmt.setString(2, inventory.getUom());
		    			stmt.setString(3, inventory.getDepot());
		    			stmt.setString(4, inventory.getIcgQty());
		    			stmt.setString(5, inventory.getEquipment());
		    			stmt.setString(6, inventory.getPartNo());
		    			stmt.setString(7, inventory.getsPartNo());
		    			stmt.setString(8, inventory.getDescr());
		    			stmt.setString(9, inventory.getSku());
		    			stmt.setString(10, inventory.getSku());
		    			stmt.setString(11, inventory.getSku());
		    			stmt.setString(12, inventory.getSku());
		    			stmt.setString(13, inventory.getSku());
		    			stmt.setString(14, inventory.getSku());
		    			stmt.setString(15, inventory.getSku());

		    			status = stmt.executeUpdate();
		    			
					jsonNode=objectMapper.valueToTree(status);
					responseModel = new ResponseModel(true, ConstantExtension.SUCCESS_RECEIVE, jsonNode);
				
		       
		    }catch(Exception e) {
				e.printStackTrace();
				responseModel = new ResponseModel(false, ConstantExtension.MESSAGE_ERROR, jsonNode);
			}
					
				}

		
       
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


