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
import com.loghub.dao.SearchInventoryLppDao;
import com.loghub.dto.InventoryDTO;
import com.loghub.dto.ResponseModel;
import com.loghub.extention.ConstantExtension;
import com.loghub.extention.HelperExtension;
import com.loghub.utils.JdbcConnectionUtil;

import oracle.jdbc.OracleTypes;

public class SearchInventoryLppDaoImpl  implements SearchInventoryLppDao{

ObjectMapper objectMapper;
HelperExtension helperExtension = new HelperExtension();
		
public ResponseModel getInventoryLppSearch(String partNo, String desc, String equipment, String ledgerNo) {
		JsonNode jsonNode = null;
		objectMapper = new ObjectMapper();
		ResponseModel responseModel;
		
		Connection con = JdbcConnectionUtil.getConnection();
		PreparedStatement stmt = null;
		ResultSet rset = null;
		CallableStatement callableStatement = null;
		List<InventoryDTO> searchDTOList = new ArrayList<InventoryDTO>();
		try {
		//String viewInventoryStatus = "{call getInventoryLpp(?,?,?,?,?)}";
			String viewInventoryStatus = "{call getLastPurchasePrice(?,?,?,?,?)}";
			callableStatement = con.prepareCall(viewInventoryStatus);
			callableStatement.setString(1, partNo);
			callableStatement.setString(2, desc);
			callableStatement.setString(3, equipment);
			callableStatement.setString(4, ledgerNo);
			
			callableStatement.registerOutParameter(5, OracleTypes.CURSOR);
			
			callableStatement.executeUpdate();

			rset = (ResultSet) callableStatement.getObject(5);
			while (rset.next()) {				
				InventoryDTO inventoryDTO=new InventoryDTO();
				inventoryDTO.setPartNo(rset.getString(1));
				inventoryDTO.setsPartNo(rset.getString(2));
				inventoryDTO.setDescr(rset.getString(3));
				inventoryDTO.setEquipment(rset.getString(4));
				inventoryDTO.setLedgerNo(rset.getString(5));
				inventoryDTO.setUnitPrice(rset.getString(6));
				inventoryDTO.setCurrency(rset.getString(7));
				inventoryDTO.setSku(rset.getString(8));
				searchDTOList.add(inventoryDTO);
				
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

