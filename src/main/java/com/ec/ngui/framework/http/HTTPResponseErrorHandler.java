package com.ec.ngui.framework.http;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: HTTPResponseErrorHandler.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: HTTPResponseErrorHandler.java Jul 30, 2015 3:47:16 PM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 30, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
public class HTTPResponseErrorHandler implements ResponseErrorHandler {

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpStatus status = response.getStatusCode();
		HttpStatus.Series series = status.series();
        return (HttpStatus.Series.CLIENT_ERROR.equals(series)
                || HttpStatus.Series.SERVER_ERROR.equals(series));
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		// TODO Auto-generated method stub
		
	}

}

/*
*$Log: av-env.bat,v $
*/