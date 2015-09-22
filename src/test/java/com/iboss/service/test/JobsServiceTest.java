package com.iboss.service.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
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

import com.iboss.IBossApplication;
import com.iboss.entity.Job;
import com.iboss.repository.JobsRepository;
import com.iboss.service.JobsService;

@ContextConfiguration(classes = { IBossApplication.class })
@RunWith(MockitoJUnitRunner.class)
public class JobsServiceTest {

	private static final Logger LOGGER = Logger.getLogger(IBossApplication.class);
	
	@InjectMocks
	@Autowired
	private JobsService jobsService;
	
	@Mock
	JobsRepository jobsRepository;

	@Before
	public void setUp() {
		
		MockitoAnnotations.initMocks(this);
		List<Job> jobs = new ArrayList<Job>();
		
		Job job = new Job();
		job.setJobDescription("Java Test");
	
		jobs.add(job);
		
		Mockito.when(jobsRepository.searchJobs(Mockito.anyString())).thenReturn(jobs);
	}

	@Test
	public void testSearchJobs() throws SQLException {
		LOGGER.info("Inside TEST search jobs == " + jobsService);
		
		List<Job> jobs = jobsService.searchJobs("JAVA");
		
		Assert.assertNotNull("Fond null jobs object with keyword 'JAVA': ", jobs);
		
		Assert.assertEquals(1, jobs.size());
		
		Assert.assertEquals("Java Test", jobs.get(0).getJobDescription());
		
		LOGGER.info("Search Jobs TEST has been completed with # of result " + jobs.size());

	}

}
