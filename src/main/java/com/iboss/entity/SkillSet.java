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
@Table(name = "SKILLSET")
public class SkillSet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SKILLSET_ID")
	private Long id;

	@Column(name = "SKILLSET_NAME", nullable = false, length = 100)
	private String name;

	@ManyToOne
	@JoinColumn(name = "TECHNOLOGY_STACK_ID")
	private TechnologyStack technologyStack;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TechnologyStack getTechnologyStack() {
		return technologyStack;
	}

	public void setTechnologyStack(TechnologyStack technologyStack) {
		this.technologyStack = technologyStack;
	}
}
