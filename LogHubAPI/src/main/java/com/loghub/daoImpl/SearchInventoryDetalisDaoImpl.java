package com.loghub.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loghub.dao.SearchInventoryDetalisDao;
import com.loghub.dto.InventoryDTO;
import com.loghub.dto.ResponseModel;
import com.loghub.extention.ConstantExtension;
import com.loghub.extention.HelperExtension;
import com.loghub.utils.JdbcConnectionUtil;

import oracle.jdbc.OracleTypes;


public class SearchInventoryDetalisDaoImpl implements SearchInventoryDetalisDao{

	ObjectMapper objectMapper;
	HelperExtension helperExtension = new HelperExtension();
	
	public ResponseModel getInventoryDetalisSearch(String partNo, String desc, String depot){

			JsonNode jsonNode = null;
			objectMapper = new ObjectMapper();
			ResponseModel responseModel;
			
			Connection con = JdbcConnectionUtil.getConnection();
			PreparedStatement stmt = null;
			ResultSet rset = null;
			CallableStatement callableStatement = null;
			List<InventoryDTO> searchDTOList = new ArrayList<InventoryDTO>();
			try {
			String viewInventoryStatus = "{call getInventoryDetails(?,?,?,?)}";
				callableStatement = con.prepareCall(viewInventoryStatus);
				callableStatement.setString(1, partNo);
				callableStatement.setString(2, desc);
				callableStatement.setString(3, depot);
				callableStatement.registerOutParameter(4, OracleTypes.CURSOR);
				
				callableStatement.executeUpdate();

				rset = (ResultSet) callableStatement.getObject(4);
				while (rset.next()) {				
					InventoryDTO inventoryDTO=new InventoryDTO();
					inventoryDTO.setPartNo(rset.getString(1));
					inventoryDTO.setsPartNo(rset.getString(2));
					inventoryDTO.setDescr(rset.getString(3));
					inventoryDTO.setDepot(rset.getString(4));
					inventoryDTO.setEquipment(rset.getString(5));
					inventoryDTO.setIcgQty(rset.getString(6));
					inventoryDTO.setUom(rset.getString(7));
					inventoryDTO.setLedgerNo(rset.getString(8));
					inventoryDTO.setUnitPrice(rset.getString(9));
					inventoryDTO.setCurrency(rset.getString(10));
					searchDTOList.add(inventoryDTO);
				}
				jsonNode=objectMapper.valueToTree(searchDTOList);
				responseModel = new ResponseModel(true, ConstantExtension.SUCCESS_RECEIVE, jsonNode);
				
								
			}catch(Exception e) {
				responseModel = new ResponseModel(false, ConstantExtension.MESSAGE_ERROR, jsonNode);
				e.printStackTrace();
			}finally{
				try {
					if(callableStatement != null)
						callableStatement.close();
					if(con != null)
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			
			return responseModel;
		
		}
		
	}

