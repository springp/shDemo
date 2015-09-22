package com.iboss.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.iboss.enums.JobType;

@Entity
@Table(name = "JOB")
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "JOB_ID")
	private Long id;

	@Column(name = "JOB_UUID")
	private String jobUUID;

	@ManyToOne(optional = false)
	@JoinColumn(name = "USER_ID", nullable = false)
	private User client;

	@Column(name = "DESCRIPTION")
	private String jobDescription;

	@Column(name = "JOB_CATEGORY")
	// @Column(name = "CATEGORY_ID")
	private Long categoryId;

	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "JOB_TYPE")
	private JobType jobType;

	@Column(name = "JOB_BUGGET")
	private BigDecimal bugget;

	@Column(name = "JOB_HOURLY_RATE")
	private BigDecimal rate;

	@Column(name = "JOB_DURATION")
	private String jobDuration;

	@OneToMany(mappedBy = "job")
	private List<JobRequiredSkillSet> skillSet;

	@OneToMany(mappedBy = "job")
	private List<JobContract> contracts;

	// @OneToMany(mappedBy = "job")
	@Transient
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

	public String getJobDuration() {
		return jobDuration;
	}

	public void setJobDuration(String jobDuration) {
		this.jobDuration = jobDuration;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public List<JobRequiredSkillSet> getSkillSet() {
		return skillSet;
	}

	public void setSkillSet(List<JobRequiredSkillSet> skillSet) {
		this.skillSet = skillSet;
	}

	// public List<JobContract> getContracts() {
	// return contracts;
	// }
	//
	// public void setContracts(List<JobContract> contracts) {
	// this.contracts = contracts;
	// }

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	// public Category getJobCategory() {
	// return jobCategory;
	// }
	//
	// public void setJobCategory(Category jobCategory) {
	// this.jobCategory = jobCategory;
	// }

	public Date getCreatedDate() {
		return createdDate;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public List<JobContract> getContracts() {
		return contracts;
	}

	public void setContracts(List<JobContract> contracts) {
		this.contracts = contracts;
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

	public List<Praposals> getPraposals() {
		return praposals;
	}

	public void setPraposals(List<Praposals> praposals) {
		this.praposals = praposals;
	}
}
