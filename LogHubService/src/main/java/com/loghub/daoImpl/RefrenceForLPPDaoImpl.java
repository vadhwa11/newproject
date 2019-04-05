package com.loghub.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.OracleTypes;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loghub.dao.RefrenceForLPPDao;
import com.loghub.dto.InventoryDTO;
import com.loghub.dto.ResponseModel;
import com.loghub.dto.SearchLastPurchasePriceDTO;
import com.loghub.extention.ConstantExtension;
import com.loghub.extention.HelperExtension;
import com.loghub.utils.JdbcConnectionUtil;

public class RefrenceForLPPDaoImpl implements RefrenceForLPPDao{

	ObjectMapper objectMapper;
	HelperExtension helperExtension = new HelperExtension();
	
//	@Override
	public ResponseModel gerRefForLPP(String sku) {
		
		ResponseModel responseModel = null;
		JsonNode jsonNode = null;
		objectMapper = new ObjectMapper();
		
		Connection con = JdbcConnectionUtil.getConnection();
		
		List<SearchLastPurchasePriceDTO> list = new ArrayList<SearchLastPurchasePriceDTO>();
		
		ResultSet rset = null;
		CallableStatement callableStatement = null;
		try {
			String viewLppReference = "{call getLppReference(?,?)}";
			callableStatement = con.prepareCall(viewLppReference);
			callableStatement.setString(1, sku);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
			
			callableStatement.executeUpdate();

			rset = (ResultSet) callableStatement.getObject(2);
			while (rset.next()) {	
				SearchLastPurchasePriceDTO lastPurchasePriceDTO = new SearchLastPurchasePriceDTO();
				if(rset.getString(1)!=null && rset.getString(1).length()>0 && rset.getString(1)!="")
					lastPurchasePriceDTO.setSupplyOrderNo(rset.getString(1));
				if(rset.getString(2)!=null && rset.getString(2).length()>0 && rset.getString(2)!="")
					lastPurchasePriceDTO.setSupplyOrderDate(rset.getString(2));
				if(rset.getString(3)!=null && rset.getString(3).length()>0 && rset.getString(3)!="")
					lastPurchasePriceDTO.setSupplier(rset.getString(3));
				if(rset.getString(4)!=null && rset.getString(4).length()>0 && rset.getString(4)!="")	
					lastPurchasePriceDTO.setCrvNo(rset.getString(4));
				if(rset.getString(5)!=null && rset.getString(5).length()>0 && rset.getString(5)!="")
					lastPurchasePriceDTO.setCrvDate(rset.getString(5));
				if(rset.getString(6)!=null && rset.getString(6).length()>0 && rset.getString(6)!="")
					lastPurchasePriceDTO.setDepot(rset.getString(6));
				if(rset.getString(7)!=null && rset.getString(7).length()>0 && rset.getString(7)!="")
					lastPurchasePriceDTO.setUnitPrice(rset.getString(7));
				if(rset.getString(8)!=null && rset.getString(8).length()>0 && rset.getString(8)!="")
					lastPurchasePriceDTO.setCurrency(rset.getString(8));
				
				list.add(lastPurchasePriceDTO);
			}
		/*	String selectQuerySKU = "select so_no, so_date, supplier, crv_no, crv_date, unit_price, cur from lms_log_RV where sku='"+sku+"'"; //select * from lms_sku where sku ='"+sku+"'";
			skuStmt = con.prepareStatement(selectQuerySKU);
			rsetsku = skuStmt.executeQuery();
			while(rsetsku.next()) {
				SearchLastPurchasePriceDTO lastPurchasePriceDTO = new SearchLastPurchasePriceDTO();
				lastPurchasePriceDTO.setSupplyOrderNo(rsetsku.getString(1));
				lastPurchasePriceDTO.setSupplyOrderDate(rsetsku.getString(2));
				lastPurchasePriceDTO.setSupplier(rsetsku.getString(3));
				lastPurchasePriceDTO.setCrvNo(rsetsku.getString(4));
				lastPurchasePriceDTO.setCrvDate(rsetsku.getString(5));
				lastPurchasePriceDTO.setDepot(rsetsku.getString(6));
				lastPurchasePriceDTO.setUnitPrice(rsetsku.getString(7));
				lastPurchasePriceDTO.setCurrency(rsetsku.getString(8));
				list.add(lastPurchasePriceDTO);
			}*/
			
			jsonNode = objectMapper.valueToTree(list);
			responseModel = new ResponseModel(true, ConstantExtension.SUCCESS_RECEIVE, jsonNode);
			
		}catch(Exception e) {
			e.printStackTrace();
			responseModel = new ResponseModel(false, ConstantExtension.MESSAGE_ERROR, jsonNode);
		}finally {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return responseModel;
	}

}
