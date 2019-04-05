package com.icg.dao;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import com.icg.model.Currency;
import com.icg.model.CurrencyDTO;
import com.icg.util.MessageExtension;
import com.icg.util.RestClientForGet;

@Repository
public class SearchCurrencyDaoImpl implements SearchCurrencyDao{

	@Override
	public List<CurrencyDTO> getSearchCurrency(String currencyName) {
		List<CurrencyDTO> listObject = new ArrayList<CurrencyDTO>();
		RestClientForGet restClientForGet = new RestClientForGet();
		String url;
		try {
			url = MessageExtension.BASE_URL+"searchcurrency?currencyName="+URLEncoder.encode(currencyName,"UTF-8")+"";
		
		String responseObject = restClientForGet.getRestClientForGet(url);
		
		JSONObject jsonObject = new JSONObject(responseObject);
		JSONArray jsonArray = jsonObject.optJSONArray("object");
				
		
		
		if(jsonArray!=null) {
			for(int i=0;i<jsonArray.length();i++) {
				JSONObject jsonObjects = jsonArray.optJSONObject(i);
			 CurrencyDTO currencyDto = new CurrencyDTO();
			 currencyDto.setCurrencyName(jsonObjects.getString("currencyName"));
			 currencyDto.setCurrencyValue(jsonObjects.getString("currencyValue"));
			 System.out.println("listObject :: "+listObject.size());
			listObject.add(currencyDto);
			System.out.println("listObject1 :: "+listObject.size());
		}
		}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listObject;
	}

}
