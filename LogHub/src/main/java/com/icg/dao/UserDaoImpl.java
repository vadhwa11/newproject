package com.icg.dao;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.icg.model.User;
import com.icg.util.MessageExtension;
import com.icg.util.RestClientForPost;

@Repository
public class UserDaoImpl implements UserDao {

	/*private static RestTemplate restTemplate = new RestTemplate();
	 private static final String baseURL = "http://localhost:8082/LogHubAPI/webapi/";*/
	 
	/*@Autowired
	RestClientForPost restClientForPost;*/
	
	@Override
	public User validateUser(User user) {

		System.out.println(user.getUserId());
		System.out.println(user.getPassword());
		System.out.println("-------------------------------------------------------------");
		
		//restClientForPost.getRestClientForPost("http://localhost:8082/LogHubAPI/webapi/login",user);
		//user=restTemplate.getForObject(baseURL+"account/1", User.class);
		//Account account = new Account("Arnav Rajput", "Noida", 312.33);
		/*User user1 = restTemplate.postForObject(baseURL+"login", user, User.class);
*/
		
		RestClientForPost restClientForPost = new RestClientForPost();
		String url = MessageExtension.BASE_URL+"login?userName="+user.getUserId()+"&password="+user.getPassword()+"";
		System.out.println("URL ::: "+url);
		String responseObj = restClientForPost.getRestClientForPost(url);
		
		JSONObject jsonObject = new JSONObject(responseObj);
		JSONArray jsonArray = jsonObject.optJSONArray("object");
		//System.out.println(jsonObject.toString());
		User user1 = new User();
		
		 if (jsonArray != null) {
             for (int i = 0; i < jsonArray.length(); i++) {
                 JSONObject jsonObjects = jsonArray.optJSONObject(i);
              
                 user1.setUserName(jsonObjects.optString("userName"));
    			 user1.setUserType(jsonObjects.optString("userType"));
    			 user1.setOrgUnit("D(IT)");//jsonObjects.optString("orgUnit"));

             }
         }
		
		return user1;
	}

}
