package com.icg.dao;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import com.icg.model.Currency;
import com.icg.model.Depot;
import com.icg.model.Uom;
import com.icg.util.MessageExtension;
import com.icg.util.RestClientForGet;
import com.icg.util.RestClientForPost;

@Repository
public class UtilsDaoImpl implements UtilsDao {

	@Override
	public List<Depot> getDepot() {
		RestClientForGet restClientForGet = new RestClientForGet();
		String url = MessageExtension.BASE_URL+"getDepot";
		System.out.println("URL ::: "+url);
		String responseObj = restClientForGet.getRestClientForGet(url);
		
		JSONObject jsonObject = new JSONObject(responseObj);
		JSONArray jsonArray = jsonObject.optJSONArray("object");
		//System.out.println(jsonObject.toString());
		
		List<Depot> depotList=new ArrayList<Depot>();
		
		 if (jsonArray != null) {
             for (int i = 0; i < jsonArray.length(); i++) {
                 JSONObject jsonObjects = jsonArray.optJSONObject(i);
                 Depot depot = new Depot();
                 depot.setDepotId(jsonObjects.optString("depotId"));
    			 depot.setDepotName(jsonObjects.optString("depotName"));
    			 depotList.add(depot);

             }
         }
		
		return depotList;
	}

	@Override
	public List<Currency> getCurrency() {
		RestClientForGet restClientForGet = new RestClientForGet();
		String url = MessageExtension.BASE_URL+"getCurrency";
		System.out.println("URL ::: "+url);
		String responseObj = restClientForGet.getRestClientForGet(url);
		
		JSONObject jsonObject = new JSONObject(responseObj);
		JSONArray jsonArray = jsonObject.optJSONArray("object");
		//System.out.println(jsonObject.toString());
		
		List<Currency> currencyList=new ArrayList<Currency>();
		
		 if (jsonArray != null) {
             for (int i = 0; i < jsonArray.length(); i++) {
                 JSONObject jsonObjects = jsonArray.optJSONObject(i);
                 Currency currency = new Currency();
                 System.out.println("................."+jsonObjects.optString("currencyName"));
                 currency.setCurrencyName(jsonObjects.optString("currencyName"));
                 currency.setCurrencyValue(jsonObjects.optString("currencyValue"));
                 currencyList.add(currency);

             }
         }
		
		return currencyList;
	}

	@Override
	public List<Uom> getUom() {


		RestClientForGet restClientForGet = new RestClientForGet();
		String url = MessageExtension.BASE_URL+"getUom";
		System.out.println("URL ::: "+url);
		String responseObj = restClientForGet.getRestClientForGet(url);
		
		JSONObject jsonObject = new JSONObject(responseObj);
		JSONArray jsonArray = jsonObject.optJSONArray("object");
		//System.out.println(jsonObject.toString());
		
		List<Uom> uomList=new ArrayList<Uom>();
		
		 if (jsonArray != null) {
             for (int i = 0; i < jsonArray.length(); i++) {
                 JSONObject jsonObjects = jsonArray.optJSONObject(i);
                 Uom uom = new Uom();
                 uom.setUomId(jsonObjects.optString("uomId"));
    			 uom.setUom(jsonObjects.optString("uom"));
    			 uomList.add(uom);

             }
         }
		
		return uomList;
	}

	@Override
	public String getMaxSku() {
		RestClientForGet restClientForGet = new RestClientForGet();
		String url = MessageExtension.BASE_URL+"getMaxSku";
		System.out.println("URL ::: "+url);
		String responseObj = restClientForGet.getRestClientForGet(url);
		
		JSONObject jsonObject = new JSONObject(responseObj);
		//JSONArray jsonArray = jsonObject.optJSONArray("object");
		//System.out.println(jsonObject.toString());
		
		String sku=jsonObject.optString("object");
		System.out.println("sku :: "+sku);
		/* if (jsonArray != null) {
             for (int i = 0; i < jsonArray.length(); i++) {
                 JSONObject jsonObjects = jsonArray.optJSONObject(i);
                 Uom uom = new Uom();
                 uom.setUomId(jsonObjects.optString("uomId"));
    			 uom.setUom(jsonObjects.optString("uom"));
    			 uomList.add(uom);

             }
         }*/
		
		return sku;
	}
	}
