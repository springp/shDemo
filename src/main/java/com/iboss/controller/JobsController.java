package com.iboss.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iboss.bo.JobBO;
import com.iboss.entity.Job;
import com.iboss.service.JobsService;
import com.iboss.util.AppUtils;

@Controller
public class JobsController {

	private static final Logger LOGGER = Logger.getLogger(JobsController.class);
	
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	JobsService jobsService;
	
	
	@RequestMapping(value = "/search-jobs", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView searchJobs(HttpServletRequest request, HttpServletResponse response, @PathVariable Map<String, String> pathVariables) throws IOException {
		LOGGER.info("Inside / path.....");
		return new ModelAndView("search");
	}	

	@RequestMapping(value = "/search-jobs/**", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView filterJobs(HttpServletRequest request, HttpServletResponse response, @PathVariable Map<String, String> pathVariables) throws IOException {
		LOGGER.info("Inside / path.....");
		String[] filters = AppUtils.splitURI(request);
		return new ModelAndView("forward:/home.htm");
	}	
	
	public ModelAndView postJob(HttpServletRequest request, HttpServletResponse response,  @ModelAttribute("jobDto") JobBO job) throws IOException {
		LOGGER.info("Controller : Inside post job");
		ModelAndView modelAndView = new ModelAndView("list_jobs");
		try {
			Job newJob = jobsService.postJob(job);
			LOGGER.debug("Controller : New job has been posted in category - " + newJob.getCategoryId());
		} catch (Exception e) {
			LOGGER.error("Error while posting new JOB", e);
		}
		return modelAndView;
	}
}
