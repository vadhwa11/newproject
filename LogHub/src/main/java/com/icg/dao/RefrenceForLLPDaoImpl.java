package com.icg.dao;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import com.icg.model.Inventory;
import com.icg.model.RefrenceForLLP;
import com.icg.util.MessageExtension;
import com.icg.util.RestClientForGet;
import com.icg.util.VMSUtils;

@Repository
public class RefrenceForLLPDaoImpl implements RefrenceForLLPDao{

	@Override
	public List<RefrenceForLLP> refrenceForLPP(String sku) {
		
		
		RestClientForGet restClientForGet = new RestClientForGet();
		String url = MessageExtension.BASE_URL+"refForLPP?sku="+sku+"";
		
		String finalUrl=VMSUtils.URLify(url);
		System.out.println(" Final URL ::: "+finalUrl);
		String responseObj = restClientForGet.getRestClientForGet(finalUrl);
		
		JSONObject jsonObject = new JSONObject(responseObj);
		JSONArray jsonArray = jsonObject.optJSONArray("object");
		
		List<RefrenceForLLP> listOfRefForLLP=new ArrayList<RefrenceForLLP>();
		 if (jsonArray != null) {
			 for (int i = 0; i < jsonArray.length(); i++) {
				 JSONObject jsonObjects = jsonArray.optJSONObject(i);
				 RefrenceForLLP refForLLP = new RefrenceForLLP();
				 refForLLP.setSupplyOrderNo(jsonObjects.optString("supplyOrderNo"));
				 refForLLP.setSupplyOrderDate(VMSUtils.dateInDDMMYYYY(jsonObjects.optString("supplyOrderDate")));
				 refForLLP.setSupplier(jsonObjects.optString("supplier"));
				 refForLLP.setCrvNo(jsonObjects.optString("crvNo"));
				 refForLLP.setDepot(jsonObjects.optString("depot"));
				 refForLLP.setCrvDate(VMSUtils.dateInDDMMYYYY(jsonObjects.optString("crvDate")));
				 refForLLP.setUnitPrice(jsonObjects.optString("unitPrice"));
				 refForLLP.setCurrency(jsonObjects.optString("currency"));
				 
				 listOfRefForLLP.add(refForLLP);
			 }
		 }
		
		return listOfRefForLLP;
	}

}
