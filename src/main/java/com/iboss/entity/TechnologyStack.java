package com.iboss.entity;

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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "TECHNOLOGY_STACK")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class TechnologyStack {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TECHNOLOGY_STACK_ID")
	private Long id;

	@Column(name = "TECHNOLOGY_STACK_NAME", nullable = false, length = 100)
	private String name;

	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID")
	private Category category;

	@OneToMany(mappedBy = "technologyStack")
	@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
	private List<SkillSet> skillSets;
	
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
