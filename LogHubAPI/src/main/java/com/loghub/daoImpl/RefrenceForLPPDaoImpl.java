package com.loghub.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loghub.dao.RefrenceForLPPDao;
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
		
		Connection connection = JdbcConnectionUtil.getConnection();
		PreparedStatement skuStmt = null;
		ResultSet rsetsku = null;
		
		List<SearchLastPurchasePriceDTO> list = new ArrayList<SearchLastPurchasePriceDTO>();
		
		try {
			String selectQuerySKU = "select so_no, so_date, supplier, crv_no, crv_date, unit_price, cur from lms_log_RV where sku='"+sku+"'"; //select * from lms_sku where sku ='"+sku+"'";
			skuStmt = connection.prepareStatement(selectQuerySKU);
			rsetsku = skuStmt.executeQuery();
			while(rsetsku.next()) {
				SearchLastPurchasePriceDTO lastPurchasePriceDTO = new SearchLastPurchasePriceDTO();
				lastPurchasePriceDTO.setSupplyOrderNo(rsetsku.getString(1));
				lastPurchasePriceDTO.setSupplyOrderDate(rsetsku.getString(2));
				lastPurchasePriceDTO.setSupplier(rsetsku.getString(3));
				lastPurchasePriceDTO.setCrvNo(rsetsku.getString(4));
				lastPurchasePriceDTO.setCrvDate(rsetsku.getString(5));
				lastPurchasePriceDTO.setUnitPrice(rsetsku.getString(6));
				lastPurchasePriceDTO.setCurrency(rsetsku.getString(7));
				list.add(lastPurchasePriceDTO);
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
