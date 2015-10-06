package com.iboss.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

import com.iboss.enums.JobStatus;

public class AppUtils {

	public static final String[] splitURI(HttpServletRequest request){
		String path = request.getRequestURI().substring(request.getContextPath().length());
		return path.split("/");		
	}
	
	public static final String getJobTypeString(String jobType){
		try {
			 return (String) (StringUtils.isEmpty(jobType) ? JobStatus.ALL.name() : JobStatus.valueOf(jobType).name());
		} catch (Exception e) {
			return JobStatus.ALL.name();
		}
	}
}
