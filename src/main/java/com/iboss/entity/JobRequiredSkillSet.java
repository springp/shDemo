package com.iboss.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "JOB_REQUIRED_SKILLSET")
public class JobRequiredSkillSet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "JOB_REQUIRED_SKILLSET_ID", unique = true, nullable = false)
	private Long id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "SKILLSET_ID", nullable = false)
	private SkillSet skillSet;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "JOB_ID", nullable = false)
	private Job job;
	
}
