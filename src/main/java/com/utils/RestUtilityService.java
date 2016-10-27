package com.utils;

import java.io.File;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.FileEntity;
import org.apache.http.impl.client.DefaultHttpClient;



public class RestUtilityService {

    private HttpClient httpClient;
    private String containerName = "test_container";
    private String objectStoreUrl = "http://172.99.106.175:8080/v1/AUTH_test/"+containerName;
    
	private String authToken ="";

    @SuppressWarnings("deprecation")
	private HttpClient getHttpClient() {
    	
    	if(httpClient == null) {
    		return new DefaultHttpClient();
    	}
    	return httpClient;
    }
	
	public boolean addObjectToContainer(File filepath) {
		
		int statusCode= 404;
	    httpClient = getHttpClient();
	    HttpPut postFile = new HttpPut(objectStoreUrl+"/"+filepath.getName());
	    try{
	    	postFile.setHeader("X-Auth-Token", authToken);
	    	postFile.setHeader("Content-Type", "application/octet-stream");
	    	postFile.setEntity(new FileEntity(filepath));
	    	
	    	System.out.println("Adding file to object store");
	    	
	    	HttpResponse response = httpClient.execute(postFile);
	        statusCode = response.getStatusLine().getStatusCode();
	    	
	        if(statusCode == 201){
	             System.out.println(response.getStatusLine());
	             Header[] headers = response.getAllHeaders();
	             for(Header header : headers)
	                 System.out.println(header.getName() + " " + header.getValue());
	             return true;
	         } else {
	             System.out.println(response.getStatusLine());
	         }
	        
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	    
		return false;
	}
	
}
