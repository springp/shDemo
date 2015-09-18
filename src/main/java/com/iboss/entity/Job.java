package com.iboss.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.iboss.enums.JobType;

//@Entity
//@Table(name = "USER_JOB")
public class Job {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "JOB_ID")
	private Long id;
	
	private User clientId;
	
	private String jobDescription;
		
	private Category jobCategory;
	
	private Date createdDate;
	
	private JobType jobType;
	
	private BigDecimal bugget;
	
	private BigDecimal rate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getClientId() {
		return clientId;
	}

	public void setClientId(User clientId) {
		this.clientId = clientId;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public Category getJobCategory() {
		return jobCategory;
	}

	public void setJobCategory(Category jobCategory) {
		this.jobCategory = jobCategory;
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

}
