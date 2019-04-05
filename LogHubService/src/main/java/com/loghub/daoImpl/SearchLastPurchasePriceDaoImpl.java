package com.loghub.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loghub.dao.SearchLastPurchasePriceDao;
import com.loghub.dto.ResponseModel;
import com.loghub.dto.SearchLastPurchasePriceDTO;
import com.loghub.extention.ConstantExtension;
import com.loghub.extention.HelperExtension;
import com.loghub.utils.JdbcConnectionUtil;

public class SearchLastPurchasePriceDaoImpl implements SearchLastPurchasePriceDao{

	ObjectMapper objectMapper;
	HelperExtension helperExtension = new HelperExtension();
	
	//@Override
	public ResponseModel getLastPurchasePrice(String partNo) {
		
		ResponseModel responseModel = null;
		JsonNode jsonNode = null;
		objectMapper = new ObjectMapper();
		
		SearchLastPurchasePriceDTO dto = new SearchLastPurchasePriceDTO();
		
		Connection connection = JdbcConnectionUtil.getConnection();
		PreparedStatement partNoPStmt = null;
		ResultSet rsetpartNo = null;
		
		List<SearchLastPurchasePriceDTO> list = new ArrayList<SearchLastPurchasePriceDTO>();
		
		
			try {
				//String selectPartNoQuery = "select partno, s_partno, descr, equipment, ledgerno, unit_price, cur from lms_sku where partno='"+partNo+"'";
				String selectPartNoQuery = "select * from lms_sku where partno='"+partNo+"'";
				partNoPStmt = connection.prepareStatement(selectPartNoQuery);
				rsetpartNo = partNoPStmt.executeQuery();
				while(rsetpartNo.next()) {
					SearchLastPurchasePriceDTO lastPurchasePriceDTO = new SearchLastPurchasePriceDTO();
					lastPurchasePriceDTO.setSupplyOrderNo(rsetpartNo.getString(1));
					lastPurchasePriceDTO.setSupplyOrderDate(rsetpartNo.getString(2));
					lastPurchasePriceDTO.setSupplier(rsetpartNo.getString(3));
					lastPurchasePriceDTO.setCrvNo(rsetpartNo.getString(4));
					lastPurchasePriceDTO.setCrvDate(rsetpartNo.getString(5));
					lastPurchasePriceDTO.setUnitPrice(rsetpartNo.getString(6));
					lastPurchasePriceDTO.setCurrency(rsetpartNo.getString(7));
					list.add(lastPurchasePriceDTO);
				}
				
				jsonNode = objectMapper.valueToTree(list);
				responseModel = new ResponseModel(true, ConstantExtension.SUCCESS_RECEIVE, jsonNode);
			}catch(Exception e) {
				e.printStackTrace();
				responseModel = new ResponseModel(false, ConstantExtension.MESSAGE_ERROR, jsonNode);
			}
		
			finally {
				try {
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		return responseModel;
	}

}
