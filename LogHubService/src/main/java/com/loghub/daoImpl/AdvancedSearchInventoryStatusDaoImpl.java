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
import com.loghub.dao.AdvancedSearchInventoryStatusDao;
import com.loghub.dto.InventoryDTO;
import com.loghub.dto.ResponseModel;
import com.loghub.extention.ConstantExtension;
import com.loghub.extention.HelperExtension;
import com.loghub.utils.JdbcConnectionUtil;

import oracle.jdbc.OracleTypes;

public class AdvancedSearchInventoryStatusDaoImpl implements AdvancedSearchInventoryStatusDao{

	ObjectMapper objectMapper;
	HelperExtension helperExtension = new HelperExtension();
	
	public ResponseModel getAdvancedInventoryStatusSearch(String advancePartNo, String advDescr, String partRadio) {
		
		JsonNode jsonNode = null;
		objectMapper = new ObjectMapper();
		ResponseModel responseModel;
		
		Connection con = JdbcConnectionUtil.getConnection();
		PreparedStatement stmt = null;
		ResultSet rset = null;
		CallableStatement callableStatement = null;
		List<InventoryDTO> searchDTOList = new ArrayList<InventoryDTO>();
		System.out.println("Before try... procedure calling...");
		try {
			System.out.println("After try... procedure calling...");
			
			//System.out.println("advanceSearchInventory :: "+advanceSearchInventory);
			
			//System.out.println("ADV callableStatement1 :: "+callableStatement);
			//System.out.println("advancePartNo :: "+advancePartNo);
			//System.out.println("advDescr :: "+advDescr);
			//System.out.println("partRadio :: "+partRadio);
			String advanceSearchInventory = "{call getInventoryAdvanceSearch(?,?,?,?)}";
			callableStatement = con.prepareCall(advanceSearchInventory);
			callableStatement.setString(1, advancePartNo);
			callableStatement.setString(2, advDescr);
			callableStatement.setString(3, partRadio);
			callableStatement.registerOutParameter(4, OracleTypes.CURSOR);
			callableStatement.executeUpdate();
			
			rset = (ResultSet)callableStatement.getObject(4);
			
			while(rset.next()) {
				//System.out.println("rset.next() :: " +rset.next());
				InventoryDTO inventoryDTO=new InventoryDTO();
				//System.out.println("ADV get data from service rset.getString(1) :: "+rset.getString(1));
				//System.out.println("ADV get data from service rset.getString(2) :: "+rset.getString(2));
				inventoryDTO.setPartNo(rset.getString(1));
				inventoryDTO.setsPartNo(rset.getString(2));
				inventoryDTO.setAdvDescr(rset.getString(3));
				inventoryDTO.setDepot(rset.getString(4));
				inventoryDTO.setEquipment(rset.getString(5));
				inventoryDTO.setIcgQty(rset.getString(6));
				inventoryDTO.setLedgerNo(rset.getString(7));
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
