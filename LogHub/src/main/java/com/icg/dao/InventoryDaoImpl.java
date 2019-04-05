package com.icg.dao;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;





import com.icg.model.Inventory;
import com.icg.model.User;
import com.icg.util.MessageExtension;
import com.icg.util.RestClientForGet;
import com.icg.util.RestClientForPost;
import com.icg.util.VMSUtils;

@Repository
public class InventoryDaoImpl implements InventoryDao{

	/*@Autowired
	RestClientForPost restClientForPost;*/
	
	@Override
	public int addInventory(Inventory inventory) {

		int status=0;
		
		RestClientForPost restClientForPost = new RestClientForPost();
		String url;
		try {
			url = MessageExtension.BASE_URL+"addInventory?"
					+ "sku="+inventory.getSku()+"&uom="+inventory.getUom()+""
					+ "&depot="+inventory.getDepot()+""
					+ "&icgQty="+inventory.getIcgQty()+""
					+ "&equipment="+inventory.getEquipment()+""
					+ "&partNo="+inventory.getPartNo()+""
					+ "&sPartNo="+inventory.getsPartNo()+""
					+ "&descr="+inventory.getDescr()+""
					+ "&ledgerNo="+inventory.getLedgerNo()+""
					+ "&unitPrice="+inventory.getUnitPrice()+""
					+ "&currency="+URLEncoder.encode(inventory.getCurrency(),"UTF-8")+""
					+ "&cat="+inventory.getCat()+""
					+ "&msl="+inventory.getMsl()+""
					+ "&xDept="+inventory.getxDept()+""
					+ "&skuFinal="+inventory.getSkuFinal()+"";
		
						
		System.out.println("URL ::: "+url);
		String finalUrl=VMSUtils.URLify(url);
		System.out.println(" Final URL ::: "+finalUrl);
		String responseObj = restClientForPost.getRestClientForPost(finalUrl);
		
		JSONObject jsonObject = new JSONObject(responseObj);
		status=Integer.parseInt(jsonObject.optString("object"));
		/*JSONArray jsonArray = jsonObject.optJSONArray("object");
		
		
		 if (jsonArray != null) {
             for (int i = 0; i < jsonArray.length(); i++) {
                 JSONObject jsonObjects = jsonArray.optString();
              
                 user1.setUserName(jsonObjects.optString("userName"));
    			 user1.setUserType(jsonObjects.optString("userType"));
    			 user1.setOrgUnit(jsonObjects.optString("orgUnit"));

             }
         }*/
		} catch (	Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	

	@Override
	public List<Inventory> viewInventory(String sku) {
		RestClientForGet restClientForGet = new RestClientForGet();
		String url = MessageExtension.BASE_URL+"searchInventory?sku="+sku+"";
						
		System.out.println("URL ::: "+url);
		String finalUrl=VMSUtils.URLify(url);
		System.out.println(" Final URL ::: "+finalUrl);
		String responseObj = restClientForGet.getRestClientForGet(finalUrl);
		
		JSONObject jsonObject = new JSONObject(responseObj);
		JSONArray jsonArray = jsonObject.optJSONArray("object");
		//System.out.println(jsonObject.toString());
		Inventory inventory = new Inventory();
		List<Inventory> listInventory=new ArrayList<Inventory>();
		
		 if (jsonArray != null) {
             for (int i = 0; i < jsonArray.length(); i++) {
                 JSONObject jsonObjects = jsonArray.optJSONObject(i);
              
                 inventory.setSku(jsonObjects.optString("sku"));
                 inventory.setUom(jsonObjects.optString("uom"));
                 inventory.setDepot(jsonObjects.optString("depot"));
                 inventory.setIcgQty(jsonObjects.optString("icgQty"));
                 inventory.setEquipment(jsonObjects.optString("equipment"));
                 inventory.setPartNo(jsonObjects.optString("partNo"));
                 inventory.setsPartNo(jsonObjects.optString("sPartNo"));
                 inventory.setDescr(jsonObjects.optString("descr"));
                 inventory.setLedgerNo(jsonObjects.optString("ledgerNo"));
                 inventory.setUnitPrice(jsonObjects.optString("unitPrice"));
                 inventory.setCurrency(jsonObjects.optString("currency"));
                 inventory.setCat(jsonObjects.optString("cat"));
                 inventory.setMsl(jsonObjects.optString("msl"));
                 inventory.setxDept(jsonObjects.optString("xDept"));
                 inventory.setSkuFinal(jsonObjects.optString("skuFinal"));
                 listInventory.add(inventory);
             }
         }
		
		return listInventory;
	}


	@Override
	public int updateInventory(Inventory inventory) {
 
		int status=0;
		try{
		RestClientForPost restClientForPost = new RestClientForPost();
		String url = MessageExtension.BASE_URL+"updateInventory?skuForUpdate="+inventory.getSku()+""
				+ "&sku="+inventory.getSku()+""
				+ "&uom="+inventory.getUom()+""
				+ "&depot="+inventory.getDepot()+""
				+ "&icgQty="+inventory.getIcgQty()+""
				+ "&equipment="+inventory.getEquipment()+""
				+ "&partNo="+inventory.getPartNo()+""
				+ "&sPartNo="+inventory.getsPartNo()+""
				+ "&descr="+inventory.getDescr()+""
				+ "&ledgerNo="+inventory.getLedgerNo()+""
				+ "&unitPrice="+inventory.getUnitPrice()+""
				+ "&currency="+URLEncoder.encode(inventory.getCurrency(),"UTF-8")+""
				+ "&cat="+inventory.getCat()+""
				+ "&msl="+inventory.getMsl()+""
				+ "&xDept="+inventory.getxDept()+""
				+ "&skuFinal="+inventory.getSkuFinal()+"";
						
		System.out.println("URL ::: "+url);
		String finalUrl=VMSUtils.URLify(url);
		System.out.println(" Final URL ::: "+finalUrl);
		String responseObj = restClientForPost.getRestClientForPost(finalUrl);
		
		JSONObject jsonObject = new JSONObject(responseObj);
		status=Integer.parseInt(jsonObject.optString("object"));
		/*JSONArray jsonArray = jsonObject.optJSONArray("object");
		//System.out.println(jsonObject.toString());
		User user1 = new User();
		
		 if (jsonArray != null) {
             for (int i = 0; i < jsonArray.length(); i++) {
                 JSONObject jsonObjects = jsonArray.optJSONObject(i);
              
                 user1.setUserName(jsonObjects.optString("userName"));
    			 user1.setUserType(jsonObjects.optString("userType"));
    			 user1.setOrgUnit("D(IT)");//jsonObjects.optString("orgUnit"));

             }
         }*/
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return status;
	}



	@Override
	public List<Inventory> searchInventoryStatus(String partNo, String desc, String depot,String sku, String equipment,String ledgerNo) {
		RestClientForGet restClientForGet = new RestClientForGet();
		
		String url = MessageExtension.BASE_URL+"searchInventoryStatus?partNo="+partNo+"&desc="+desc+"&depot="+depot+"&sku="+sku+"&equipment="+equipment+"&ledgerNo="+ledgerNo+"";
		
		String finalUrl=VMSUtils.URLify(url);
		System.out.println(" Final URL ::: "+finalUrl);
		String responseObj = restClientForGet.getRestClientForGet(finalUrl);
		
		JSONObject jsonObject = new JSONObject(responseObj);
		JSONArray jsonArray = jsonObject.optJSONArray("object");
		//System.out.println("sarla======="+jsonObject.toString());
		//Inventory inventory = new Inventory();
		List<Inventory> listInventory=new ArrayList<Inventory>();
		
		 if (jsonArray != null) {
             for (int i = 0; i < jsonArray.length(); i++) {
                 JSONObject jsonObjects = jsonArray.optJSONObject(i);
                 Inventory inventory = new Inventory();
         		 inventory.setPartNo(jsonObjects.optString("partNo"));
                 inventory.setsPartNo(jsonObjects.optString("sPartNo"));
                 inventory.setDescr(jsonObjects.optString("descr"));
                 inventory.setDepot(jsonObjects.optString("depot"));
                 inventory.setEquipment(jsonObjects.optString("equipment"));
                 inventory.setIcgQty(jsonObjects.optString("icgQty"));
                 inventory.setLedgerNo(jsonObjects.optString("ledgerNo"));
                listInventory.add(inventory);
             }
         }
		return listInventory;
	}
	
	//advnacedSearchInventoryStatus
	@Override
	public List<Inventory> advnacedSearchInventoryStatus(String advancePartNo, String advDescr, String partRadio) {
		System.out.println("Client DAOIMP :: "+advancePartNo);
		System.out.println("Client DAOIMP :: "+advDescr);
		System.out.println("Client DAOIMP :: "+partRadio);
		RestClientForGet restClientForGet = new RestClientForGet();
		String url = MessageExtension.BASE_URL+"advancedSearchInventoryStatus?advancePartNo="+advancePartNo+"&advDescr="+advDescr+"&partRadio="+partRadio+"";
		
		String finalUrl=VMSUtils.URLify(url);
		System.out.println(" Final URL for advnacedSearchInv ::: "+finalUrl);
		String responseObj = restClientForGet.getRestClientForGet(finalUrl);
		
		JSONObject jsonObject = new JSONObject(responseObj);
		JSONArray jsonArray = jsonObject.optJSONArray("object");
		//System.out.println("sarla======="+jsonObject.toString());
		//Inventory inventory = new Inventory();
		List<Inventory> listInventory=new ArrayList<Inventory>();
		
		 if (jsonArray != null) {
             for (int i = 0; i < jsonArray.length(); i++) {
                 JSONObject jsonObjects = jsonArray.optJSONObject(i);
                 Inventory inventory = new Inventory();
         		 inventory.setPartNo(jsonObjects.optString("partNo"));
                 inventory.setsPartNo(jsonObjects.optString("sPartNo"));
                 inventory.setDescr(jsonObjects.optString("descr"));
                 inventory.setDepot(jsonObjects.optString("depot"));
                 inventory.setEquipment(jsonObjects.optString("equipment"));
                 inventory.setIcgQty(jsonObjects.optString("icgQty"));
                 inventory.setLedgerNo(jsonObjects.optString("ledgerNo"));
                listInventory.add(inventory);
             }
         }
		return listInventory;
	}
	

	@Override
	public List<Inventory> searchInventoryDetails(String partNo, String desc, String depot){
		RestClientForGet restClientForGet = new RestClientForGet();
		String url = MessageExtension.BASE_URL+"searchInventoryDetails?partNo="+partNo+"&desc="+desc+"&depot="+depot+"";
						
		//System.out.println("URL ::: "+url);
		String finalUrl=VMSUtils.URLify(url);
		//System.out.println(" Final URL ::: "+finalUrl);
		String responseObj = restClientForGet.getRestClientForGet(finalUrl);
		
		JSONObject jsonObject = new JSONObject(responseObj);
		JSONArray jsonArray = jsonObject.optJSONArray("object");
		//System.out.println("sarla======="+jsonObject.toString());
		//Inventory inventory = new Inventory();
		List<Inventory> listInventory=new ArrayList<Inventory>();
		
		 if (jsonArray != null) {
	         for (int i = 0; i < jsonArray.length(); i++) {
	             JSONObject jsonObjects = jsonArray.optJSONObject(i);
	             Inventory inventory = new Inventory();
	             inventory.setPartNo(jsonObjects.optString("partNo"));
	             inventory.setsPartNo(jsonObjects.optString("sPartNo"));
	             inventory.setDescr(jsonObjects.optString("descr"));
	             inventory.setDepot(jsonObjects.optString("depot"));
	             inventory.setEquipment(jsonObjects.optString("equipment"));
                 inventory.setIcgQty(jsonObjects.optString("icgQty"));
                 inventory.setUom(jsonObjects.optString("uom"));
                 inventory.setLedgerNo(jsonObjects.optString("ledgerNo"));
                 inventory.setUnitPrice(jsonObjects.optString("unitPrice"));
                 inventory.setCurrency(jsonObjects.optString("currency"));
                
	             listInventory.add(inventory);
	         }
	     }
		
		return listInventory;
	}

	@Override
	public List<Inventory> searchInventoryLpp(String partNo, String desc, String equipment, String ledgerNo){
		RestClientForGet restClientForGet = new RestClientForGet();
		String url = MessageExtension.BASE_URL+"searchInventoryLpp?partNo="+partNo+"&desc="+desc+"&equipment="+equipment+"&ledgerNo="+ledgerNo+"";
						
		//System.out.println("URL ::: "+url);
		String finalUrl=VMSUtils.URLify(url);
		//System.out.println(" Final URL ::: "+finalUrl);
		String responseObj = restClientForGet.getRestClientForGet(finalUrl);
		
		JSONObject jsonObject = new JSONObject(responseObj);
		JSONArray jsonArray = jsonObject.optJSONArray("object");
		//System.out.println("sarla======="+jsonObject.toString());
		//Inventory inventory = new Inventory();
		List<Inventory> listInventory=new ArrayList<Inventory>();
		
		 if (jsonArray != null) {
	         for (int i = 0; i < jsonArray.length(); i++) {
	             JSONObject jsonObjects = jsonArray.optJSONObject(i);
	             Inventory inventory = new Inventory();
	             inventory.setSku(jsonObjects.optString("sku"));
	             inventory.setPartNo(jsonObjects.optString("partNo"));
	             inventory.setsPartNo(jsonObjects.optString("sPartNo"));
	             inventory.setDescr(jsonObjects.optString("descr"));
	             inventory.setEquipment(jsonObjects.optString("equipment"));
	             inventory.setLedgerNo(jsonObjects.optString("ledgerNo"));
	             inventory.setUnitPrice(jsonObjects.optString("unitPrice"));
	             inventory.setCurrency(jsonObjects.optString("currency"));
	             inventory.setDepot(jsonObjects.optString("depot"));
	             inventory.setIcgQty(jsonObjects.optString("icgQty"));
	            
	            listInventory.add(inventory);
	         }
	     }
		
		return listInventory;
	}


	
	
}