package com.iboss.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "CATEGORY")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CATEGORY_ID")
	private Long id;

	@Column(name = "CATEGORY_NAME", nullable = false, length = 100)
	private String name;

	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER )
	@Fetch(value = FetchMode.SUBSELECT)
	@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
	private List<TechnologyStack> technologyStack;

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

	public List<TechnologyStack> getTechnologyStack() {
		return technologyStack;
	}

	public void setTechnologyStack(List<TechnologyStack> technologyStack) {
		this.technologyStack = technologyStack;
	}

}
