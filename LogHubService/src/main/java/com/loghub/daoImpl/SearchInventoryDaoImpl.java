package com.loghub.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loghub.dao.SearchInventoryDao;
import com.loghub.dto.InventoryDTO;
import com.loghub.dto.LoginDTO;
import com.loghub.dto.ResponseModel;
import com.loghub.extention.ConstantExtension;
import com.loghub.extention.HelperExtension;
import com.loghub.utils.ActiveDirectoryAuthentication;
import com.loghub.utils.JdbcConnectionUtil;

public class SearchInventoryDaoImpl implements SearchInventoryDao{

	ObjectMapper objectMapper;
	HelperExtension helperExtension = new HelperExtension();
	
	public ResponseModel getInventoryDetails(String sku) {
		
		

			ResponseModel responseModel;
			JsonNode jsonNode = null;
			objectMapper = new ObjectMapper();
			InventoryDTO inventoryDto = new InventoryDTO();
		
	
	  List<InventoryDTO> inventoryDtoList = new ArrayList<InventoryDTO>();
		   
		        	String query = "select SKU,UOM,DEPOT,ICG_QTY,EQUIPMENT,PARTNO,S_PARTNO,DESCR,LEDGERNO,UNIT_PRICE,"
		        			+ "CUR,CAT,MSL,XDEPT,SKU_FINAL from LMS_SKU where SKU='" + sku + "'";
					
		    		Connection con = JdbcConnectionUtil.getConnection();
		    		Statement stmt = null;

		    		try {
		    			stmt = con.createStatement();

		    			ResultSet rset = stmt.executeQuery(query);
		    			while (rset.next()) {
		    				inventoryDto.setSku(rset.getString(1));
		    				inventoryDto.setUom(rset.getString(2));
		    				inventoryDto.setDepot(rset.getString(3));
		    				inventoryDto.setIcgQty(rset.getString(4));
		    				inventoryDto.setEquipment(rset.getString(5));
		    				inventoryDto.setPartNo(rset.getString(6));
		    				inventoryDto.setsPartNo(rset.getString(7));
		    				inventoryDto.setDescr(rset.getString(8));
		    				inventoryDto.setLedgerNo(rset.getString(9));
		    				inventoryDto.setUnitPrice(rset.getString(10));
		    				inventoryDto.setCurrency(rset.getString(11));
		    				inventoryDto.setCat(rset.getString(12));
		    				inventoryDto.setMsl(rset.getString(13));
		    				inventoryDto.setxDept(rset.getString(14));
		    				inventoryDto.setSkuFinal(rset.getString(15));
		    				
		    				inventoryDtoList.add(inventoryDto);
		    			}

		    		
		        	//dto.setUserName(userName);
		        	//loginDTO.add(dto);
					jsonNode=objectMapper.valueToTree(inventoryDtoList);
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


