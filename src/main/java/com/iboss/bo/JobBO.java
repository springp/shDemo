package com.iboss.bo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.iboss.entity.JobContract;
import com.iboss.entity.JobRequiredSkillSet;
import com.iboss.entity.Praposals;
import com.iboss.entity.User;
import com.iboss.enums.JobType;

public class JobBO {

	private Long id;

	private String jobUUID;
	
	private String jobName;

	private User client;

	private String jobDescription;

	private Long categoryId;

	private Date createdDate;

	private JobType jobType;
	
	private String jobStatus;

	@NumberFormat(style = Style.NUMBER)
	private BigDecimal bugget;

	private BigDecimal rate;

	private String jobDuration;

	private List<JobRequiredSkillSet> skillSet;

	private List<JobContract> contracts;

	private List<Praposals> praposals;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJobUUID() {
		return jobUUID;
	}

	public void setJobUUID(String jobUUID) {
		this.jobUUID = jobUUID;
	}
	
	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public JobType getJobType() {
		return jobType;
	}

	public void setJobType(JobType jobType) {
		this.jobType = jobType;
	}
	
	public String getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}

	public BigDecimal getBugget() {
		return bugget;
	}

	public void setBugget(BigDecimal bugget) {
		this.bugget = bugget;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public String getJobDuration() {
		return jobDuration;
	}

	public void setJobDuration(String jobDuration) {
		this.jobDuration = jobDuration;
	}

	public List<JobRequiredSkillSet> getSkillSet() {
		return skillSet;
	}

	public void setSkillSet(List<JobRequiredSkillSet> skillSet) {
		this.skillSet = skillSet;
	}

	public List<JobContract> getContracts() {
		return contracts;
	}

	public void setContracts(List<JobContract> contracts) {
		this.contracts = contracts;
	}

	public List<Praposals> getPraposals() {
		return praposals;
	}

	public void setPraposals(List<Praposals> praposals) {
		this.praposals = praposals;
	}

}
