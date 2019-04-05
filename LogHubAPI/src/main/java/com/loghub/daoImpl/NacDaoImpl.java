package com.loghub.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loghub.dao.NacDao;
import com.loghub.dto.InventoryDTO;
import com.loghub.dto.NacDTO;
import com.loghub.dto.NacItemDTO;
import com.loghub.dto.ResponseModel;
import com.loghub.extention.ConstantExtension;
import com.loghub.extention.HelperExtension;
import com.loghub.utils.JdbcConnectionUtil;

import oracle.jdbc.OracleTypes;

public class NacDaoImpl implements NacDao{

	ObjectMapper objectMapper;
	HelperExtension helperExtension = new HelperExtension();
	
//	@Override
	public ResponseModel getNacDetails(String partNo, String depot, String fromDate, String toDate) {
		
		ResponseModel responseModel = null;
		JsonNode jsonNode = null;
		objectMapper = new ObjectMapper();
		
		Connection connection = JdbcConnectionUtil.getConnection();
		PreparedStatement nacPStmt = null;
		ResultSet rsetNac = null;
		CallableStatement callableStatement = null;
		List<NacItemDTO> list = new ArrayList<NacItemDTO>();
		
		try {
			
			/*String nacDetailsQuery = "{call GETNACDETAILS_2(?,?,?,?,?)}";
			callableStatement = connection.prepareCall(nacDetailsQuery);
			callableStatement.setString(1, partNo);
			callableStatement.setString(2, depot);
			callableStatement.setString(3, fromDate);
			callableStatement.setString(4, toDate);
			
			callableStatement.registerOutParameter(5, OracleTypes.CURSOR);
			callableStatement.executeUpdate();
			
			rsetNac = (ResultSet)callableStatement.getObject(5);
			while(rsetNac.next()) {
				NacItemDTO nacItemDTO = new NacItemDTO();
				nacItemDTO.setSku(rsetNac.getString(1));
				nacItemDTO.setPartNo(rsetNac.getString(2));
				nacItemDTO.setDescription(rsetNac.getString(3));
				nacItemDTO.setEquipment(rsetNac.getString(4));
				nacItemDTO.setQty(rsetNac.getInt(5));
				nacItemDTO.setTransaction(rsetNac.getString(6));
				
				NacDTO nacDTO = new NacDTO();
				nacDTO.setNacNo(rsetNac.getInt(7));
				nacDTO.setNacDate(rsetNac.getString(8));
				
				nacItemDTO.setNacDto(nacDTO);
				list.add(nacItemDTO);
			}*/
			
			
			String nacQuery = "select lmsni.sku,lmsni.partNo, lmsni.descr, lmsni.equipment, lmsni.qty, lmsni.tx_id, ln.nac_No, ln.nac_Date, sku.ledgerno" + 
					" from lms_nac_item lmsni" + 
					" join lms_nac ln on lmsni.sku = ln.sku" + 
					" join lms_sku sku on lmsni.partno=sku.partno "+
					" where lmsni.PARTNO='"+partNo+"'";
			nacPStmt = connection.prepareStatement(nacQuery);
			rsetNac = nacPStmt.executeQuery();
			while(rsetNac.next()) {
				NacItemDTO nacItemDTO = new NacItemDTO();
				nacItemDTO.setSku(rsetNac.getString(1));
				nacItemDTO.setPartNo(rsetNac.getString(2));
				nacItemDTO.setDescription(rsetNac.getString(3));
				nacItemDTO.setEquipment(rsetNac.getString(4));
				nacItemDTO.setQty(rsetNac.getInt(5));
				nacItemDTO.setTransaction(rsetNac.getString(6));
				
					NacDTO nacDTO = new NacDTO();
					nacDTO.setNacNo(rsetNac.getInt(7));
					nacDTO.setNacDate(rsetNac.getString(8));
					
					InventoryDTO inventoryDTO = new InventoryDTO();
					inventoryDTO.setLedgerNo(rsetNac.getString(9));
					
				List<NacDTO> nacList = new ArrayList<NacDTO>();
					nacList.add(nacDTO);
				
				nacItemDTO.setNacDto(nacDTO);
				nacItemDTO.setInventoryDTO(inventoryDTO);
				
				
				list.add(nacItemDTO);
			}
			
			jsonNode = objectMapper.valueToTree(list);
			responseModel = new ResponseModel(true, ConstantExtension.SUCCESS_RECEIVE, jsonNode);
		}catch(Exception e) {
			e.printStackTrace();
			responseModel = new ResponseModel(false, ConstantExtension.MESSAGE_ERROR, jsonNode);
		}
		return responseModel;
	}

}
