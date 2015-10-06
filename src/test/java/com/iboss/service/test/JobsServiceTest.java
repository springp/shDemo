package com.iboss.service.test;

import java.sql.SQLException;
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
import com.iboss.enums.JobType;
import com.iboss.repository.JobsRepository;
import com.iboss.service.JobsService;
import com.iboss.testutil.TestDataUtil;

@ContextConfiguration(classes = { IBossApplication.class })
@RunWith(MockitoJUnitRunner.class)
public class JobsServiceTest {

	private static final Logger LOGGER = Logger.getLogger(JobsServiceTest.class);
	
	@InjectMocks
	@Autowired
	private JobsService jobsService;
	
	@Mock
	JobsRepository jobsRepository;

	@Before
	public void setUp() {
		
		MockitoAnnotations.initMocks(this);
		
		//Mock the job repository search job method
		Mockito.when(jobsRepository.searchJobs(Mockito.anyString())).thenReturn(TestDataUtil.getJobList());
		
		//Mock the job repository save method
		Mockito.when(jobsRepository.save(Mockito.any(Job.class))).thenReturn(1l);
	}

	//@Test
	public void testSearchJobs() throws SQLException {
		LOGGER.info("Inside TEST search jobs");
		
		List<Job> jobs = jobsService.searchJobs("JAVA");
		
		Assert.assertNotNull("Fond null jobs object with keyword 'JAVA': ", jobs);
		
		Assert.assertEquals(1, jobs.size());
		
		Assert.assertEquals("Required Java developer for Liferay project", jobs.get(0).getJobDescription());
		
		LOGGER.info("Search Jobs TEST has been completed with # of result " + jobs.size());

	}
	
	@Test
	public void testPostJob() throws SQLException {
		LOGGER.info("Inside TEST post job");
		
		Job job = jobsService.postJob(TestDataUtil.getJobBO());
		
		Assert.assertNotNull("Unable to post new job - returns null", job);
		
		Assert.assertSame("Expected job id is not same", 1l, job.getId());
		
		Assert.assertSame("Expected job is not HOURLY job", JobType.HOURLY, job.getJobType());
		
		Assert.assertSame("Expected job rate is 10$", 10, job.getRate().intValue());
		
		LOGGER.info("TEST post job completed.....");

	}

}
