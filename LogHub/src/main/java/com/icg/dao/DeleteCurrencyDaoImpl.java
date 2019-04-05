package com.icg.dao;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonParser;
import com.icg.util.MessageExtension;
import com.icg.util.RestClientForGet;
import com.icg.util.VMSUtils;

@Repository
public class DeleteCurrencyDaoImpl implements DeleteCurrencyDao{

	@Override
	public String  deleteCurrency(String currencyName) {
		
		RestClientForGet restClientForGet = new RestClientForGet();
		String url=null;
		try {
			url = MessageExtension.BASE_URL+"deleteCurrency?currencyName="+URLEncoder.encode(currencyName,"UTF-8")+"";
		}catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		System.out.println("URL ::: "+url);
		String finalUrl=VMSUtils.URLify(url);
		System.out.println(" Final URL ::: "+finalUrl);
		
		String responseObj = restClientForGet.getRestClientForGet(url);
		
		System.out.println("resobj "+responseObj);
		JSONObject jsonObject = new JSONObject(responseObj);
		
		
		String status = jsonObject.optString("status");
		
		
		System.out.println("status status :: "+status);
		return status;
	}

}
