package com.iboss.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iboss.repository.JobsRepository;

@Controller
public class IBossController {

	private static final Logger LOGGER = Logger.getLogger(IBossController.class);

	@Autowired
	MessageSource messageSource;

	@Autowired
	JobsRepository jobsRepository;
	
	@RequestMapping(value = "/" , method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView welcomePage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		LOGGER.info("Inside / path.....");
		return new ModelAndView("forward:/home.htm");
	}
	
	@RequestMapping(value = "/home.htm", method = RequestMethod.GET)
	public ModelAndView home() {
		LOGGER.info("Inside home method.....");		
		ModelAndView model = new ModelAndView();	
		/*try {

			StopWatch watch = new StopWatch();
			watch.start();

			List<User> users = jobsRepository.searchJobs("pankaj");
			
			watch.stop();			
			LOGGER.info("Total time using Lucene: " + watch.getTotalTimeSeconds());
			
			LOGGER.info("Number of users: " + users);		
		} catch (Exception e) {
			LOGGER.error("Error occurred while fetching users: ", e);
		}*/
		model.setViewName("home");
		return model;
	}
	
	@RequestMapping(value = "/login.htm", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout) {
		LOGGER.info("Inside login method.....");
		
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			return new ModelAndView("forward:/list");
		}

		model.setViewName("login");
		return model;
	}
}
