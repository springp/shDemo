package com.iboss.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iboss.entity.Category;
import com.iboss.repository.CategoryRepository;

@Service
public class CategoryService {
	
	private static final Logger LOGGER = Logger.getLogger(CategoryService.class);

	@Autowired
	CategoryRepository categoryRepository;

	
//	@Transactional
	public List<Category> findAll() {
		List<Category> categories = categoryRepository.findAll();
		return categories;
	}

	public Category findById(Long id) {
		return categoryRepository.findById(id);
	}
}
