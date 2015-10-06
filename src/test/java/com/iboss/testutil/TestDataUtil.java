package com.iboss.testutil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;

import com.iboss.bo.JobBO;
import com.iboss.entity.Job;
import com.iboss.entity.JobRequiredSkillSet;
import com.iboss.entity.SkillSet;
import com.iboss.entity.TechnologyStack;
import com.iboss.enums.JobType;

public class TestDataUtil {

	// BOs with predefined values
	public static final JobBO getJobBO() {
		JobBO jobBO = new JobBO();
		jobBO.setId(1l);
		jobBO.setJobUUID(UUID.randomUUID().toString());
		jobBO.setCategoryId(1l);
		jobBO.setBugget(BigDecimal.TEN);
		jobBO.setCreatedDate(new Date());
		jobBO.setJobDescription("Required Java developer for Liferay project");
		jobBO.setJobDuration("1 Month");
		jobBO.setJobType(JobType.HOURLY);
		jobBO.setRate(BigDecimal.TEN);
		jobBO.setSkillSet(getJobRequiredSkillSetList());
		return jobBO;
	}

	// Entities with predefined values

	public static final Job getJob() {
		Job job = new Job();
		try {
			BeanUtils.copyProperties(job, getJobBO());
		} catch (Exception e) {
			return null;
		}
		return job;
	}

	public static final List<Job> getJobList() {
		List<Job> jobs = new ArrayList<Job>();
		jobs.add(getJob());
		return jobs;
	}
	
	public static final TechnologyStack getTechnologyStackwithData() {
		TechnologyStack technologyStack = new TechnologyStack();
		technologyStack.setId(1l);
		technologyStack.setName("JAVA");
		return technologyStack;
	}

	public static final SkillSet getSkillSet() {
		SkillSet skillSet = new SkillSet();
		skillSet.setId(1l);
		skillSet.setName("Liferay");
		skillSet.setTechnologyStack(getTechnologyStackwithData());
		return skillSet;
	}

	public static final JobRequiredSkillSet getJobRequiredSkillSet() {
		JobRequiredSkillSet jobRequiredSkillSet = new JobRequiredSkillSet();
		jobRequiredSkillSet.setId(1l);
		jobRequiredSkillSet.setSkillSet(getSkillSet());
		return jobRequiredSkillSet;
	}

	public static final List<JobRequiredSkillSet> getJobRequiredSkillSetList() {
		List<JobRequiredSkillSet> requiredskills = new ArrayList<JobRequiredSkillSet>();
		requiredskills.add(getJobRequiredSkillSet());
		return requiredskills;
	}
}
