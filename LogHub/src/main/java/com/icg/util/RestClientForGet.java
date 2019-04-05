package com.icg.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import org.springframework.stereotype.Component;

import com.icg.model.User;

/*import org.json.JSONException;
import org.json.JSONObject;*/

@Component
public class RestClientForGet {
	
	String output= null;
	public String  getRestClientForGet(String url) {
	//public static void main(String[] args) {
		try {
			
			HttpURLConnection conn = null;
			//String url="http://localhost:8081/bisstate/bisstate/1";
			URL restUrl = new URL(url); 
			System.out.println("URL="+restUrl);
			conn = (HttpURLConnection) restUrl.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream()), "UTF-8"));
			
			System.out.println("Output from Server .... \n");
			
			StringBuffer response = new StringBuffer();
			while ((output = br.readLine()) != null) {	
				response.append(output);
				//System.out.println(output);
			}
			output = response.toString();
			br.close();
			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
			
		}
		return output;
		
	}
	
	
	
	
	/*public  String getMethod(String url) {
		String output = null;
		HttpURLConnection conn = null;

		try {
			URL urlmethod = new URL(url);
			conn = (HttpURLConnection) urlmethod.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			
			conn.setReadTimeout(10000);
			int responseCode = conn.getResponseCode();
			BufferedReader br = null;
			if (responseCode == 200) {
				br = new BufferedReader(new InputStreamReader(
						(conn.getInputStream())));

			} else {
				br = new BufferedReader(new InputStreamReader(
						(conn.getErrorStream())));
			}

			StringBuffer response = new StringBuffer();
			while ((output = br.readLine()) != null ) {
				response.append(output);
				
			}
			output = response.toString();
			
			System.out.println("Get method Response:::" + output);
			
			br.close();
			conn.disconnect();
			

		} 
		
		catch (IOException e) {

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			if(conn!=null)
			{
			conn.disconnect();
			}

		}

		return output;
	}*/

	
	
}
