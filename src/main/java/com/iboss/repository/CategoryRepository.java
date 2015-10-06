package com.iboss.repository;

import org.springframework.stereotype.Repository;

import com.iboss.entity.Category;

@Repository
public class CategoryRepository extends SimpleHibernateRepository<Category, Long> {

	protected CategoryRepository() {
		super(Category.class);
	}
}
