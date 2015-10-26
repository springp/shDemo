package com.iboss.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "JOB_CONTRACT")
public class JobContract {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "JOB_CONTRACT_ID")
	private Long id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "JOB_ID", nullable = false)
	private Job job;

	@ManyToOne(optional = false)
	@JoinColumn(name = "USER_ID", nullable = false)
	private User user;

	@Column(name = "CONTRACT_START_DATE", nullable = false)
	private Date startDate;

	@Column(name = "CONTRACT_END_DATE")
	private Date endDate;
	
	@Column(name = "USER_FEEDBACK")
	private String userFeedback;

	@Column(name = "CLIENT_FEEDBACK")
	private String clientFeedback;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getUserFeedback() {
		return userFeedback;
	}

	public void setUserFeedback(String userFeedback) {
		this.userFeedback = userFeedback;
	}

	public String getClientFeedback() {
		return clientFeedback;
	}

	public void setClientFeedback(String clientFeedback) {
		this.clientFeedback = clientFeedback;
	}

}
