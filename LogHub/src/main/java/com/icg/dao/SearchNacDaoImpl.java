package com.icg.dao;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import com.icg.model.NacItemDTO;
import com.icg.util.MessageExtension;
import com.icg.util.RestClientForGet;
import com.icg.util.VMSUtils;

@Repository
public class SearchNacDaoImpl implements SearchNacDao{

	@Override
	public List<NacItemDTO> getNacDetails(String partNo, String depot, String fromDate, String toDate) {
		
		RestClientForGet restClientForGet = new RestClientForGet();
		 String url = MessageExtension.BASE_URL+"nac?partNo="+partNo+"&depot="+depot+"&fromDate="+fromDate+"&toDate="+toDate+"";
		 System.out.println("url"+url);
		 String responseObject = restClientForGet.getRestClientForGet(url);
		 
		 JSONObject jsonObject = new JSONObject(responseObject);
		 JSONArray jsonArray = jsonObject.optJSONArray("object");
		 
		 List<NacItemDTO> listObjNacItemDTO = new ArrayList<NacItemDTO>();
		 if(jsonArray!=null) {
				for(int i=0;i<jsonArray.length();i++) {
					JSONObject jsonObjects = jsonArray.optJSONObject(i);
					NacItemDTO nacItmDTO = new NacItemDTO();		
					try{				
						 nacItmDTO.setPartNo(jsonObjects.optString("partNo"));					
						 nacItmDTO.setDescription(jsonObjects.optString("description").replaceAll("\\r\\n|\\r|\\n|&", " "));					
						 nacItmDTO.setEquipment(jsonObjects.optString("equipment"));					
						 nacItmDTO.setSignalAdd(jsonObjects.optString("signalAdd"));
						 nacItmDTO.setLedgerNo(jsonObjects.optString("ledgerNo"));
						 nacItmDTO.setNacNo(Integer.parseInt(jsonObjects.get("nacNo").toString()));
						 nacItmDTO.setNacDate(VMSUtils.dateInDDMMYYYY(jsonObjects.get("nacDate").toString()));
						 nacItmDTO.setDepot(jsonObjects.optString("depot"));
						 System.out.println("depot in client nac search .. "+jsonObjects.optString("depot"));
						 nacItmDTO.setDemandNo(jsonObjects.optString("demandNo"));
						 nacItmDTO.setDemandDate(VMSUtils.dateInDDMMYYYY(jsonObjects.get("demandDate").toString()));
						 nacItmDTO.setQuantity(jsonObjects.optString("quantity"));
					
					}catch(Exception e)
					{
						e.printStackTrace();
					}

					listObjNacItemDTO.add(nacItmDTO);
				}	
		
	}
		 return listObjNacItemDTO;
}
}

