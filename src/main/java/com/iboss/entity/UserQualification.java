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
@Table(name = "USER_QUALIFICATION")
public class UserQualification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "QUALIFICATION_ID", unique = true, nullable = false)
	private Long id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "USER_ID", nullable = false)
	private User user;

}
