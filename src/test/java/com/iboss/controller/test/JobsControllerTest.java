package com.iboss.controller.test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
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
import com.iboss.entity.JobRequiredSkillSet;
import com.iboss.entity.SkillSet;
import com.iboss.entity.TechnologyStack;
import com.iboss.enums.JobType;
import com.iboss.repository.JobsRepository;
import com.iboss.service.JobsService;

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
	
	JobBO jobBO = new JobBO();
	
	Job job = new Job();

	@Before
	public void setUp() throws IllegalAccessException, InvocationTargetException {
		
		MockitoAnnotations.initMocks(this);
		
		jobBO.setId(1l);
		jobBO.setJobUUID(UUID.randomUUID().toString());
		jobBO.setCategoryId(1l);
		jobBO.setBugget(BigDecimal.TEN);
		jobBO.setCreatedDate(new Date());
		jobBO.setJobDescription("Required Java developer for Liferay project");
		jobBO.setJobDuration("1 Month");
		jobBO.setJobType(JobType.HOURLY);
		jobBO.setJobDescription("Java Test");
		jobBO.setRate(BigDecimal.TEN);
		
		TechnologyStack technologyStack = new TechnologyStack();
		technologyStack.setId(1l);
		technologyStack.setName("JAVA");
		
		SkillSet skillSet = new SkillSet();
		skillSet.setId(1l);
		skillSet.setName("Liferay");	
		skillSet.setTechnologyStack(technologyStack);
		
		JobRequiredSkillSet jobRequiredSkillSet = new JobRequiredSkillSet();		
		jobRequiredSkillSet.setId(1l);
		jobRequiredSkillSet.setSkillSet(skillSet);
		
		List<JobRequiredSkillSet> requiredskills = new ArrayList<JobRequiredSkillSet>();
		requiredskills.add(jobRequiredSkillSet);
		
		jobBO.setSkillSet(requiredskills);
		
		BeanUtils.copyProperties(job, jobBO);
		
		Mockito.when(jobsRepository.save(Mockito.any(Job.class))).thenReturn(1l);
		
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
