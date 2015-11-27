package com.ec.ngui.framework.http;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: HttpRequest.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: HttpRequest.java Jul 29, 2015 4:19:35 PM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 29, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
public class HttpRequestUtil {
	
	public static ResponseEntity<Map> post (Map<String, Object> postBody)
	{
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json");
		String requestJson =null;
		try {
			requestJson = new ObjectMapper().writeValueAsString(postBody);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);
		
	    ResponseEntity<Map> result=null;
	    try
	    {
	    	result =getRestTemplate().postForEntity("http://localhost:8080/apis/v1/auth/token",entity, Map.class);
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
		return result;
	}
	
	public static ResponseEntity<Map> put (String url, Map<String, Object> putBody)
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String requestJson =null;
		try {
			requestJson = new ObjectMapper().writeValueAsString(putBody);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);
		ResponseEntity<Map> result=getRestTemplate().exchange(url, HttpMethod.PUT, entity, Map.class);
		 
		return result;
	}
	
	public static ResponseEntity<List> get (String url, Map<String, Object> urlVariables, HttpSession httpSession)
	{
		url="http://localhost:8080/apis/v1"+url+"?token="+httpSession.getAttribute("ssoId");
		if(urlVariables!=null && urlVariables.size()>0)
		{
			Set<String> keyes = urlVariables.keySet();
			for (String key :keyes)
			{
				url+="&"+key+"="+urlVariables.get(key);	
			}
		}
		ResponseEntity<List> result=getRestTemplate().getForEntity(url, List.class);
		return result;
	}
	
	public static ResponseEntity<Map> delete (String url, Map<String, Object> urlVariables)
	{
		ResponseEntity<Map> result=getRestTemplate().exchange(url, HttpMethod.DELETE, null, Map.class, urlVariables);
		return result;
	}
	
	private static RestTemplate getRestTemplate()
	{
		RestTemplate restTemplate = new RestTemplate();
	    restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
	    restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
	    restTemplate.setErrorHandler(new HTTPResponseErrorHandler());
	    return restTemplate;
	}
}

/*
*$Log: av-env.bat,v $
*/