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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iboss.bo.JobBO;
import com.iboss.entity.Category;
import com.iboss.entity.Job;
import com.iboss.entity.User;
import com.iboss.service.CategoryService;
import com.iboss.service.JobsService;
import com.iboss.util.AppConstants;
import com.iboss.util.AppUtils;

@Controller
public class JobsController {

	private static final Logger LOGGER = Logger.getLogger(JobsController.class);
	
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	JobsService jobsService;
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value = "/search-jobs", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView searchJobs(HttpServletRequest request, HttpServletResponse response, @PathVariable Map<String, String> pathVariables) throws IOException {
		LOGGER.info("Inside / path.....");
		return new ModelAndView("search");
	}	

	@RequestMapping(value = "/search-jobs/**", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView filterJobs(HttpServletRequest request, HttpServletResponse response, @PathVariable Map<String, String> pathVariables) throws IOException {
		LOGGER.info("Inside / path.....");
		//String[] filters = AppUtils.splitURI(request);
		return new ModelAndView("forward:/home.htm");
	}	
	
	@RequestMapping(value = "/list-client-jobs.htm", method = { RequestMethod.GET })
	public ModelAndView listClientJobs(HttpServletRequest request, HttpServletResponse response, @RequestParam (name = "jtype", required = false ) String jobType) throws IOException {
		LOGGER.info("Inside / view user jobs.....");		
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Job> jobs = jobsService.listJobs(1l, AppUtils.getJobTypeString(jobType));
			map.put("jobs", jobs);			
		} catch (Exception e) {
			map.put(AppConstants.UI_ERROR_MESSAGE, "Backend server error -Error while listing jobs, Please try again!");
			LOGGER.error("SERVICE - Backend server error -Error while listing jobs", e);
		}
		return new ModelAndView("list-client-jobs", map);		
	}	
	
	@RequestMapping(value = "/view-post-job.htm", method = { RequestMethod.GET })
	public ModelAndView viewPostJob(HttpServletRequest request, HttpServletResponse response, @PathVariable Map<String, String> pathVariables) throws IOException {
		LOGGER.info("Inside / view post job.....");
		try {
			
			List<Category>  categories = categoryService.findAll();
			
			JobBO jobBO = new JobBO();
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("jobCategories", categories);
			map.put("jobBO", jobBO);
			
			//return new ModelAndView("post-job", "jobBO", jobBO);
			return new ModelAndView("post-job", map);
		} catch (Exception e) {
		}
		return new ModelAndView("list-client-jobs");
	}
	
	@RequestMapping(value = "/post-job.htm", method = { RequestMethod.POST })
	public ModelAndView postJob(HttpServletRequest request, HttpServletResponse response,  @ModelAttribute("jobBO") JobBO job) throws IOException {
		LOGGER.info("Controller : Inside post job");
		ModelAndView modelAndView = new ModelAndView("list-client-jobs");
		try {
			
			//TODO: set logged in client id from session
			job.setClient(new User(1L));
			
			Job newJob = jobsService.postJob(job);
			LOGGER.debug("Controller : New job has been posted in category - " + newJob.getCategoryId());
		} catch (Exception e) {
			LOGGER.error("Error while posting new JOB", e);
		}
		return modelAndView;
	}

	@RequestMapping(value = "/job-details.htm", method = { RequestMethod.GET })
	public ModelAndView viewJobDetails(HttpServletRequest request, HttpServletResponse response, @RequestParam("jobId") String jobUUID) throws IOException {
		
		LOGGER.info("Controller : Inside post job");
		ModelAndView modelAndView = new ModelAndView("client/client-job_details");
		try {
			//TODO: Remove hard coded user UUID.
			String userUUID = "b000a288-17c1-4646-8cc5-c81fab18242d";
			Job job = jobsService.findByUserUUIDAndJobUUID(userUUID, jobUUID);
			modelAndView.addObject("job", job);			
			LOGGER.debug("Controller : Found job with UUID - " + jobUUID);
		} catch (Exception e) {
			LOGGER.error("Error while fetching job details", e);
		}
		return modelAndView;
	}
}
