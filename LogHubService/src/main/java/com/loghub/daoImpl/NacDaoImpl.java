package com.loghub.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loghub.dao.NacDao;
import com.loghub.dto.InventoryDTO;
import com.loghub.dto.LmsCodeUnit;
import com.loghub.dto.NacDTO;
import com.loghub.dto.NacItemDTO;
import com.loghub.dto.ResponseModel;
import com.loghub.extention.ConstantExtension;
import com.loghub.extention.HelperExtension;
import com.loghub.utils.JdbcConnectionUtil;

public class NacDaoImpl implements NacDao{

	ObjectMapper objectMapper;
	HelperExtension helperExtension = new HelperExtension();
	
//	@Override
	public ResponseModel getNacDetails(String partNo, String depot, String fromDate, String toDate) {
		
		System.out.println(" in getnacdetails daoimpl .. in API ..");
		
		ResponseModel responseModel = null;
		JsonNode jsonNode = null;
		objectMapper = new ObjectMapper();
		
		Connection connection = JdbcConnectionUtil.getConnection();
		PreparedStatement nacPStmt = null;
		ResultSet rsetNac = null;
		
		List<NacItemDTO> list = new ArrayList<NacItemDTO>();
		System.out.println("Ïn nac search dao impl");
		try {
		/*	String nacQuery = "select lmsni.sku,lmsni.partNo, lmsni.descr, lmsni.equipment, lmsni.qty, lmsni.tx_id, ln.nac_No, ln.nac_Date, sku.ledgerno" + 
					" from lms_nac_item lmsni" + 
					" join lms_nac ln on lmsni.sku = ln.sku" + 
					" join lms_sku sku on lmsni.partno=sku.partno "+
					" where lmsni.PARTNO='"+partNo+"'";
			*/
			
			
		/*	if(depot==null)
				depot="";
			if(fromDate==null)
				fromDate="";
			
			if(toDate==null)
				toDate="";
			if(partNo==null)
				partNo="";
			
			if(toDate==null)
				toDate="";*/
			
			String searchQuery = "SELECT lms_nac_item.partno, lms_nac_item.descr, lms_nac_item.EQUIPMENT, lms_code_unit.signal_add, ledgerno, lms_nac.nac_no, lms_nac.nac_date,lms_nac_item.demno,lms_nac_item.demdate,lms_nac_item.qty,lms_sku.depot FROM "
					+ " lms_nac, lms_nac_item, lms_code_unit, lms_sku WHERE lms_nac.tx_id = lms_nac_item.tx_id"
					+ " AND   lms_nac.ucode = lms_code_unit.ucode AND  lms_nac_item.sku = lms_sku.sku(+) and lms_nac_item.descr not like'%”%'";//and rownum<=50";
			/*OR substr(lms_nac_item.tx_id,1,3)='"+depot+"'"
					+ " OR lms_nac.NAC_DATE > = '"+fromDate+"' OR lms_nac.NAC_DATE  <= '"+toDate+"' OR LMS_NAC_ITEM.PARTNO = '"+partNo+"' and rownum<=2000";*/
			
			 if(partNo!=null && partNo.length()>0)
			 {
				 System.out.println("partNo:   "+partNo);
				 
				 searchQuery=searchQuery + " and LMS_NAC_ITEM.PARTNO like '" + partNo + "%'";
			 }
			 if(depot!=null && depot.length()>0)
			 {
				// System.out.println("depot:   "+depot);
				 //String dep = depot.substring(0,depot.length()-3);
				 searchQuery=searchQuery + " and substr(lms_nac_item.tx_id,1,3)= '" + depot + "'";
			 }
			 /*if((toDate==null || toDate.length()==0))
			 {
				 String fixedDate="01/01/1985";
				 System.out.println("toDate date ::"+toDate);
				 searchQuery=searchQuery + " and lms_nac.NAC_DATE between '"+toDate+"'";
			 }*/
			 
			
			 if((fromDate!=null && fromDate.length()>0))
			 {
				
				 //System.out.println("fromDate date ::"+fromDate);
				 
				 searchQuery=searchQuery + " and to_char(lms_nac.NAC_DATE,'dd/mm/yyyy') between'"+fromDate+"'";
			 }
			
			/* if(endDate==null || endDate.length()==0){
				 Calendar calender = Calendar.getInstance();
				 java.util.Date currentDate = calender.getTime();
				 java.sql.Date sysDate = new java.sql.Date(currentDate.getTime());
				 System.out.println("sys Date ::::"+sysDate);
				 //searchQuery=searchQuery + "and c.REFIT_COMP_DATE='"+sysDate+"'";
				 searchQuery=searchQuery + "and '"+sysDate+"'";
				 System.out.println("final query :::  "+searchQuery);
			 }*/
			 
			 
			 if(toDate!=null && toDate.length()>0)
			 {
				
				 //System.out.println("toDate date ::"+toDate);
				 
				 searchQuery=searchQuery + "and '"+toDate+"'";
				 System.out.println("final query :::  "+searchQuery);

			 }
			//System.out.println("nacQuery :: "+searchQuery);
					nacPStmt = connection.prepareStatement(searchQuery);
					rsetNac = nacPStmt.executeQuery();
					while(rsetNac.next()) {
					NacItemDTO nacItemDTO = new NacItemDTO();
					//nacItemDTO.setSku(rsetNac.getString(1));
					nacItemDTO.setPartNo(rsetNac.getString(1));
					nacItemDTO.setDescription(rsetNac.getString(2));
					nacItemDTO.setEquipment(rsetNac.getString(3));
					nacItemDTO.setSignalAdd(rsetNac.getString(4));
					nacItemDTO.setLedgerNo(rsetNac.getString(5));
					nacItemDTO.setNacNo(rsetNac.getInt(6));
					nacItemDTO.setNacDate(rsetNac.getString(7));
					nacItemDTO.setDemandNo(rsetNac.getString(8));
					System.out.println(" demand no in nacdaoimpl .. in api ..  :: "+rsetNac.getString(8));
					nacItemDTO.setDemandDate(rsetNac.getString(9));
					nacItemDTO.setQuantity(rsetNac.getString(10));
					nacItemDTO.setDepot(rsetNac.getString(11));
					System.out.println("depot in nac search .... "+rsetNac.getString(11));
					/*LmsCodeUnit lmsCodeUnit  = new LmsCodeUnit();
					lmsCodeUnit.setuCode(rsetNac.getString(4));					
					
					nacItemDTO.setTransaction(rsetNac.getString(5));
					 
					NacDTO nacDTO = new NacDTO();
					nacDTO.setNacNo(rsetNac.getInt(6));
					nacDTO.setNacDate(rsetNac.getString(7));*/
					 
					/*InventoryDTO inventoryDTO = new InventoryDTO();
					inventoryDTO.setLedgerNo(rsetNac.getString(9));*/
					
					/*nacItemDTO.setSku(rsetNac.getString(1));
					nacItemDTO.setPartNo(rsetNac.getString(3));
					nacItemDTO.setDescription(rsetNac.getString(5));
					nacItemDTO.setEquipment(rsetNac.getString(4));
					nacItemDTO.setQty(rsetNac.getInt(5));
					nacItemDTO.setTransaction(rsetNac.getString(6));
					 
					NacDTO nacDTO = new NacDTO();
					nacDTO.setNacNo(rsetNac.getInt(1));
					nacDTO.setNacDate(rsetNac.getString(2));
					 
					InventoryDTO inventoryDTO = new InventoryDTO();
					inventoryDTO.setLedgerNo(rsetNac.getString(9));*/
					
				/*List<NacDTO> nacList = new ArrayList<NacDTO>();
					nacList.add(nacDTO);*/
				
				//nacItemDTO.setNacDto(nacItemDTO);
				//nacItemDTO.setInventoryDTO(inventoryDTO);
				
				list.add(nacItemDTO);
				
				
			}
					System.out.println("list list in getnac details .. :: "+list.size());
			jsonNode = objectMapper.valueToTree(list);
			responseModel = new ResponseModel(true, ConstantExtension.SUCCESS_RECEIVE, jsonNode);
		}catch(Exception e) {
			e.printStackTrace();
			responseModel = new ResponseModel(false, ConstantExtension.MESSAGE_ERROR, jsonNode);
		}finally {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return responseModel;
	}

}
