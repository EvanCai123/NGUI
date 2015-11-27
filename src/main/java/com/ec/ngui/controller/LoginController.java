package com.ec.ngui.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ec.ngui.framework.http.HttpRequestUtil;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: LoginController.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: LoginController.java Jul 29, 2015 3:49:41 PM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 29, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
@Controller
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody String auth(@RequestBody Map request,HttpSession httpSession) throws ServletException, IOException
	{
		request.put("owner", "Evan");
		ResponseEntity<Map> response = HttpRequestUtil.post(request);
		if(response.getStatusCode()==HttpStatus.OK)
		{
			httpSession.setAttribute("ssoId", response.getBody().get("token"));
			return "{\"status\":\"succeed\"}"; 
		}
		else
		{
			return "{\"status\":\"failed\"}";
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody String printHello() {
		return "{\"Hello\":\"Hello\"}";
	}
	public static void main (String[] args)
	{
		Map<String ,Object> urlVariables = new HashMap<String ,Object>(); 
		
		urlVariables.put("owner", "Evan"); 
		urlVariables.put("userName", "Evan");
		urlVariables.put("password", "TGI123");
		ResponseEntity<Map> response = HttpRequestUtil.post(urlVariables);
		System.out.print(response.getBody());
	}
}

/*
*$Log: av-env.bat,v $
*/