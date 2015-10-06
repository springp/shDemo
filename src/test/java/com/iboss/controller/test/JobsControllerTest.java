package com.iboss.controller.test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.web.servlet.ModelAndView;

import com.iboss.IBossApplication;
import com.iboss.bo.JobBO;
import com.iboss.controller.JobsController;
import com.iboss.entity.Job;
import com.iboss.repository.JobsRepository;
import com.iboss.service.JobsService;
import com.iboss.testutil.TestDataUtil;

@ContextConfiguration(classes = { IBossApplication.class })
@RunWith(MockitoJUnitRunner.class)
public class JobsControllerTest {

	private static final Logger LOGGER = Logger.getLogger(JobsControllerTest.class);

	@InjectMocks
	@Autowired
	JobsController jobsController;

	@Mock
	HttpServletRequest request;

	@Mock
	HttpServletResponse response;

	@Mock
	private JobsService jobsService;

	@Mock
	JobsRepository jobsRepository;

	ModelAndView modelAndView;

	JobBO jobBO = TestDataUtil.getJobBO();

	Job job = TestDataUtil.getJob();

	@Before
	public void setUp() throws IllegalAccessException, InvocationTargetException {

		MockitoAnnotations.initMocks(this);

		//Mock the job repository save method
		Mockito.when(jobsRepository.save(Mockito.any(Job.class))).thenReturn(1l);

		//Mock the job service save method
		Mockito.when(jobsService.postJob(jobBO)).thenReturn(job);

	}

	@Test
	public void testPostJob() throws SQLException {

		LOGGER.info("Inside TEST post job.....");

		try {
			modelAndView = jobsController.postJob(request, response, jobBO);
			ModelAndViewAssert.assertViewName(modelAndView, "list_jobs");
			LOGGER.info("TEST post job completed.....");

		} catch (IOException e) {
			LOGGER.error("Error while posting new job.....", e);
		}

	}
}
