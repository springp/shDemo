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
	
	private BigDecimal price;
}
