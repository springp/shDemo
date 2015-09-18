package com.iboss.util;

import javax.servlet.http.HttpServletRequest;

public class AppUtils {

	public static final String[] splitURI(HttpServletRequest request){
		String path = request.getRequestURI().substring(request.getContextPath().length());
		return path.split("/");		
	}
}
