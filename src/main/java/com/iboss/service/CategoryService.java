package com.iboss.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iboss.entity.Category;
import com.iboss.entity.SkillSet;
import com.iboss.repository.CategoryRepository;
import com.iboss.repository.SkillsetRepossitory;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	SkillsetRepossitory skillsetRepossitory;
	
	
//	@Transactional
	public List<Category> findAll() {
		Date date1 = new Date();
		List<Category> categories = categoryRepository.findAll();
		Date date2 = new Date();
		System.out.println("Get All Cat Retrieve time: ---------------- " + (date2.getTime() - date1.getTime()));
		return categories;
	}

	public Category findById(Long id) {
		Date date1 = new Date();
		Category cat = categoryRepository.findById(id);
		Date date2 = new Date();
		System.out.println("Get All Cat Retrieve time: ---------------- " + (date2.getTime() - date1.getTime()));
		return cat;
	}
	
	public List<SkillSet> searchSkills(Long subCatId) {
		return skillsetRepossitory.searchSkills(subCatId);
	}
}
