package com.iboss.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iboss.entity.JobContract;
import com.iboss.service.JobsService;
import com.iboss.util.AppConstants;
import com.iboss.util.AppUtils;

@Controller
public class UserJobsController {

	private static final Logger LOGGER = Logger.getLogger(UserJobsController.class);
	
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	JobsService jobsService;
		
	@RequestMapping(value = "/my-jobs.htm", method = { RequestMethod.GET })
	public ModelAndView viewUserJobs(HttpServletRequest request, HttpServletResponse response, @RequestParam(name = "jtype", required = false) String jobType) throws IOException {
		LOGGER.info("Inside / view user's jobs.....");
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			
			//TODO: Remove hard coded user UUID.
			String userUUID = "b000a288-17c1-4646-8cc5-c81fab18243d";
			
			List<JobContract> contracts = jobsService.listContracts(userUUID, AppUtils.getJobTypeString(jobType));
			map.put("contracts", contracts);
		} catch (Exception e) {
			map.put(AppConstants.UI_ERROR_MESSAGE, "Backend server error -Error while listing jobs, Please try again!");
			LOGGER.error("SERVICE - Backend server error -Error while listing jobs", e);
		}
		return new ModelAndView("user/my-jobs", map);
	}
	
}
