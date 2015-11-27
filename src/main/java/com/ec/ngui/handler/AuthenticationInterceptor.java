package com.ec.ngui.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: AuthenticationInterceptor.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: AuthenticationInterceptor.java Aug 3, 2015 2:45:00 PM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Aug 3, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		Object obj = request.getSession().getAttribute("ssoId");
		if(request.getServletPath().indexOf("login")>=0 || obj!=null)
		{
			return true;
		}
		else
		{
			request.getRequestDispatcher("/").forward(request, response);  
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}

/*
*$Log: av-env.bat,v $
*/