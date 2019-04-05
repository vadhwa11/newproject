package com.loghub.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loghub.dao.GetCurrencyDao;
import com.loghub.dto.CurrencyDTO;
import com.loghub.dto.ResponseModel;
import com.loghub.extention.ConstantExtension;
import com.loghub.extention.HelperExtension;
import com.loghub.utils.JdbcConnectionUtil;

public class GetCurrencyDaoImpl implements GetCurrencyDao {

	
		ObjectMapper objectMapper;
		HelperExtension helperExtension = new HelperExtension();
		
		public ResponseModel getCurrency() {
			
			

				ResponseModel responseModel;
				JsonNode jsonNode = null;
				objectMapper = new ObjectMapper();
				
			
		
		  List<CurrencyDTO> currencyDtoList = new ArrayList<CurrencyDTO>();
			   
			        	String query = "select CUR,CUR_VALUE from LMS_CODE_CURR";
						
			    		Connection con = JdbcConnectionUtil.getConnection();
			    		Statement stmt = null;

			    		try {
			    			stmt = con.createStatement();

			    			ResultSet rset = stmt.executeQuery(query);
			    			while (rset.next()) {
			    				CurrencyDTO currencyDto = new CurrencyDTO();
			    				currencyDto.setCurrencyName(rset.getString(1));
			    				currencyDto.setCurrencyValue(rset.getString(2));
			    				currencyDtoList.add(currencyDto);
			    			}

						jsonNode=objectMapper.valueToTree(currencyDtoList);
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


