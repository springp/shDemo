package com.iboss.entity;

import java.util.Date;

public class JobContract {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "USER_JOB_CONTRACT_ID")
	private Long id;
	
	private Long jobId;
	
	private User user;

	private Date startDate;

	private Date endDate;
	
}
