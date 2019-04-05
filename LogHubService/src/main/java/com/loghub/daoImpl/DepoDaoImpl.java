package com.loghub.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loghub.dao.DepoDao;
import com.loghub.dto.DepoDTO;
import com.loghub.dto.ResponseModel;
import com.loghub.extention.ConstantExtension;
import com.loghub.extention.HelperExtension;
import com.loghub.utils.JdbcConnectionUtil;

public class DepoDaoImpl implements DepoDao{

	ObjectMapper objectMapper;
	HelperExtension helperExtension = new HelperExtension();
	
	//@Override
	public ResponseModel getDepoList(int depoId) {
		
		ResponseModel responseModel = null;
		JsonNode jsonNode = null;
		objectMapper = new ObjectMapper();
		
		Connection con = JdbcConnectionUtil.getConnection();
		PreparedStatement depoPStmt = null;
		ResultSet rsetDepo = null;
		List<DepoDTO> list = new ArrayList<DepoDTO>();
		
		try {
			String depoQuery = "select * from lms_depot where depo_Id='"+depoId+"'";
			 depoPStmt = con.prepareStatement(depoQuery);
			 rsetDepo = depoPStmt.executeQuery();
			 while(rsetDepo.next()) {
				 DepoDTO depoDTO = new DepoDTO();
				 depoDTO.setDepoId(rsetDepo.getInt(1));
				 depoDTO.setDepotName(rsetDepo.getString(2));
				 list.add(depoDTO);
			 }
			
			 jsonNode = objectMapper.valueToTree(list);
				responseModel = new ResponseModel(true, ConstantExtension.SUCCESS_RECEIVE, jsonNode);
				
		}catch(Exception e) {
			e.printStackTrace();
			responseModel = new ResponseModel(false, ConstantExtension.MESSAGE_ERROR, jsonNode);
		}
		finally {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return responseModel;
	}

}
