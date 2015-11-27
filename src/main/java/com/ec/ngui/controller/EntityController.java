package com.ec.ngui.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ec.ngui.framework.http.HttpRequestUtil;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: EntityController.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: EntityController.java Jul 30, 2015 8:48:45 PM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 30, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
@Controller
@RequestMapping("/entities")
public class EntityController {

	@Autowired
	private HttpSession httpSession;
	
	@RequestMapping(value="/{entityName}", method = RequestMethod.GET)
	public @ResponseBody List getEntities(@PathVariable String entityName) {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("owner", "Evan");
		ResponseEntity<List> response = HttpRequestUtil.get("/entities/"+entityName,request, httpSession);
		if(response.getStatusCode()==HttpStatus.OK)
		{
			return response.getBody();
		}
		return null;
	}
}

/*
*$Log: av-env.bat,v $
*/