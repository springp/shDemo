package com.iboss.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iboss.entity.Category;
import com.iboss.entity.SkillSet;
import com.iboss.repository.CategoryRepository;
import com.iboss.repository.SkillsetRepossitory;

@Service
public class CategoryService {
	
	private static final Logger LOGGER = Logger.getLogger(CategoryService.class);

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	SkillsetRepossitory skillsetRepossitory;
	
	
//	@Transactional
	public List<Category> findAll() {
		List<Category> categories = categoryRepository.findAll();
		return categories;
	}

	public Category findById(Long id) {
		return categoryRepository.findById(id);
	}
	
	public List<SkillSet> searchSkills(Long subCatId) {
		return skillsetRepossitory.searchSkills(subCatId);
	}
}
