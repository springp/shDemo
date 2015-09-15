package com.iboss.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iboss.repository.JobsRepository;

@Controller
public class SearchJobsController {

	private static final Logger LOGGER = Logger.getLogger(SearchJobsController.class);

	@Autowired
	MessageSource messageSource;

	@Autowired
	JobsRepository jobsRepository;

	@RequestMapping(value = "/search-jobs/{category}/{job_type}", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView searchJobs(HttpServletRequest request, HttpServletResponse response, @PathVariable Map<String, String> pathVariables) throws IOException {
		LOGGER.info("Inside / path.....");
		LOGGER.info("Path Variables: " + pathVariables);
		return new ModelAndView("forward:/home.htm");
	}	
}