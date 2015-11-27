package com.ec.ngui.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ec.ngui.framework.http.HttpRequestUtil;
/**
 * <pre>
 * 
 *  Next Generation
 *  File: EntityMetaController.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: EntityMetaController.java Aug 1, 2015 2:26:07 PM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Aug 1, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
@Controller
@RequestMapping("/meta")
public class EntityMetaController {

	@Autowired
	private HttpSession httpSession;
	
	@RequestMapping(value="/entities", method = RequestMethod.GET)
	public @ResponseBody List getMetaEntities() {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("owner", "Evan");
		ResponseEntity<List> response = HttpRequestUtil.get("/meta/entities",request, httpSession);
		if(response.getStatusCode()==HttpStatus.OK)
		{
			return response.getBody();
		}
		return null;
	}
	
	@RequestMapping(value="/fields", method = RequestMethod.GET)
	public @ResponseBody List getMetaFields(@RequestParam("entityId") String entityId) {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("owner", "Evan");
		request.put("entityId",entityId);
		ResponseEntity<List> response = HttpRequestUtil.get("/meta/fields",request, httpSession);
		if(response.getStatusCode()==HttpStatus.OK)
		{
			return response.getBody();
		}
		return null;
	}
	
	@RequestMapping (method = RequestMethod.GET)
	public String getMetaPage() {
		return "entity";
	}
}

/*
*$Log: av-env.bat,v $
*/