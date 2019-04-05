package com.icg.dao;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import com.icg.model.Currency;
import com.icg.util.MessageExtension;
import com.icg.util.RestClientForPost;
import com.icg.util.VMSUtils;

@Repository
public class AddCurrencyDaoImpl implements AddCurrencyDao {

	@Override
	public String addCurrency(Currency currency) {
		String status;
		System.out.println("in adddaoimpl ");
		
		System.out.println(" dao :: "+currency.getCurrencyName());
		
		RestClientForPost restClientForPost = new RestClientForPost();
		String url = null;
		try {
			url = MessageExtension.BASE_URL+"addCurrency?currencyName="+URLEncoder.encode(currency.getCurrencyName(),"UTF-8")+"&currencyValue="+currency.getCurrencyValue()+"";
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("URL ::: "+url);
		String finalUrl=VMSUtils.URLify(url);
		System.out.println(" Final URL ::: "+finalUrl);
		String responseObj = restClientForPost.getRestClientForPost(finalUrl);
		System.out.println("resobj "+responseObj);
		JSONObject jsonObject = new JSONObject(responseObj);
		status=jsonObject.optString("object");
				
				
				
		return status;
	}

	
	
	
}
