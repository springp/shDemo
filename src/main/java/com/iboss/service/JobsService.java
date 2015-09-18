package com.iboss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iboss.entity.Job;
import com.iboss.repository.JobsRepository;

@Service
public class JobsService {

	@Autowired
	JobsRepository jobsRepository;

	public List<Job> searchJobs(String keyword) {
		List<Job> jobs = jobsRepository.searchJobs(keyword);
		return jobs;
	}
}
