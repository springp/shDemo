package com.iboss.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iboss.bo.JobBO;
import com.iboss.entity.Job;
import com.iboss.entity.JobContract;
import com.iboss.enums.JobStatus;
import com.iboss.exceptions.JobException;
import com.iboss.repository.JobsRepository;

@Service
public class JobsService {

	private static final Logger LOGGER = Logger.getLogger(JobsService.class);

	@Autowired
	JobsRepository jobsRepository;

	public List<Job> searchJobs(String keyword) {
		List<Job> jobs = jobsRepository.searchJobs(keyword);
		return jobs;
	}

	public Job postJob(JobBO job) {
		LOGGER.info("SERVICE - Inside post job");
		Job newJob = new Job();
		try {

			//set job default value
			job.setJobUUID(UUID.randomUUID().toString());
			job.setJobStatus(JobStatus.OPEN.name());
			job.setCreatedDate(new Date());	
			
			BeanUtils.copyProperties(newJob, job);			
						
			Long newJobId = jobsRepository.save(newJob);
			job.setId(newJobId);

			LOGGER.debug("SERVICE - New job has been posted with UUID " + job.getJobUUID());

		} catch (IllegalAccessException e) {
			LOGGER.error("SERVICE - Invalid parameters -Error while posting new JOB", e);
			throw new JobException("Invalid parameters - Check required parameters to post new JOB", e);
		} catch (InvocationTargetException e) {
			LOGGER.error("SERVICE - Invalid parameters -Error while posting new JOB", e);
			throw new JobException("Invalid parameters - Check required parameters to post new JOB", e);
		} catch (Exception e) {
			LOGGER.error("SERVICE - Backend server error -Error while posting new JOB", e);
			throw new JobException("Backend server error while posting new JOB", e);
		}
		LOGGER.info("SERVICE - JOB has been posted");
		return newJob;
	}

	public List<Job> listJobs(Long userId, String status) {
		LOGGER.info("SERVICE - Inside List jobs");
		List<Job> results = null;
		try {
			
			LOGGER.debug("SERVICE - List jobs for UserID" + userId + " and with status " + status);
			results = jobsRepository.listJobs(userId, status);
			LOGGER.debug("SERVICE - Found # of jobs " + results);

		} catch (Exception e) {
			LOGGER.error("SERVICE - Backend server error -Error while listing jobs JOBs", e);
			throw new JobException("Backend server error while listing jobs JOBs", e);
		}
		LOGGER.info("SERVICE - List jobs completed");
		return results;
	}
	
	public List<JobContract> listContracts(String userUUID, String status) {
		LOGGER.info("SERVICE - Inside List jobs");
		List<JobContract> results = null;
		try {
			
			LOGGER.debug("SERVICE - List jobs for UserID" + userUUID + " and with status " + status);
			results = jobsRepository.listContracts(userUUID, status);
			LOGGER.debug("SERVICE - Found # of jobs " + results);

		} catch (Exception e) {
			LOGGER.error("SERVICE - Backend server error -Error while listing jobs JOBs", e);
			throw new JobException("Backend server error while listing jobs JOBs", e);
		}
		LOGGER.info("SERVICE - List jobs completed");
		return results;
	}

	public Job findByUserUUIDAndJobUUID(String userUUID, String jobUUID) {
		LOGGER.info("SERVICE - Inside job details");
		Job job = null;
		try {

			LOGGER.debug("SERVICE - Get job details for UserUUID" + userUUID + " and JobUUID " + jobUUID);
			job = jobsRepository.findByUserUUIDAndJobUUID(userUUID, jobUUID);
			LOGGER.debug("SERVICE - Found job details ");

		} catch (JobException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error("SERVICE - Backend server error while fetching job details", e);
			throw new JobException("Backend server error while fetching job details", e);
		}
		LOGGER.info("SERVICE - List jobs completed");
		return job;
	}
}

