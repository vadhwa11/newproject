package com.icg.dao;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;









import com.icg.model.Currency;
import com.icg.util.MessageExtension;
import com.icg.util.RestClientForGet;
import com.icg.util.VMSUtils;

@Repository
public class DuplicateNameDaoImpl implements DuplicateNameDao {

	@Override
	public List<String> DuplicateName(String currencyName) {
		
		
		String status;
		System.out.println("in duplicate name daoimpl ");
		
		System.out.println(" dao :: "+currencyName);
		
		RestClientForGet restClientForGet = new RestClientForGet();
		String url = null;
		
			url = MessageExtension.BASE_URL+"duplicateCurrency";
		
		
		System.out.println("URL ::: "+url);
		String finalUrl=VMSUtils.URLify(url);
		System.out.println(" Final URL ::: "+finalUrl);
		String responseObj = restClientForGet.getRestClientForGet(finalUrl);
		System.out.println("resobj "+responseObj);
		
		JSONObject jsonObject = new JSONObject(responseObj);
		JSONArray jsonArray = jsonObject.optJSONArray("object");
		List<String> currencyList=new ArrayList<String>();
		System.out.println(" status for duplicate name in daoimpl.. of client .. "+jsonArray.length());
				
		if (jsonArray != null) {
            for (int i = 0; i < jsonArray.length(); i++) {
               // JSONObject jsonObjects = jsonArray.optJSONObject(i);
               // Currency currency = new Currency();
               // System.out.println("................."+jsonObjects.optString("currencyName"));
                //currency.setCurrencyName(jsonObjects.optString("currencyName"));
                //currency.setCurrencyValue(jsonObjects.optString("currencyValue"));
                String currency=jsonArray.getString(i);
                currencyList.add(currency);

            }
        }
	
		return currencyList;
		
				
		//return status;
		
		
		
	}

}
