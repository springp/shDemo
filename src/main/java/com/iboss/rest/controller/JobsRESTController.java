package com.iboss.rest.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.iboss.bo.RESTResult;
import com.iboss.entity.Category;
import com.iboss.entity.SkillSet;
import com.iboss.entity.TechnologyStack;
import com.iboss.entity.User;
import com.iboss.service.CategoryService;

@RestController
@RequestMapping("/api")
public class JobsRESTController {

	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value = { "/search_jobs" }, method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE }, produces = {MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<RESTResult> searchData(ModelMap model, @RequestBody User user) throws IOException {
		RESTResult result = new RESTResult();
		return new ResponseEntity<RESTResult>(result, HttpStatus.OK);
	}

	
	@RequestMapping(value = { "/list_subcategory" }, method = RequestMethod.GET, consumes = {MediaType.APPLICATION_JSON_VALUE }, produces = {MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<RESTResult> listSubCategory(ModelMap model, @RequestParam("cId") String categoryId) throws IOException {
		RESTResult result = new RESTResult();
		return new ResponseEntity<RESTResult>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = { "/get_subcategories" }, method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity<RESTResult> getSubCategory(ModelMap model, @RequestParam("cId") String categoryId) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		RESTResult result = new RESTResult();		
		Category category = categoryService.findById(Long.parseLong(categoryId));		
		List<ObjectNode> subCategories = new ArrayList<ObjectNode>();
		if (category.getTechnologyStack() != null){
			for(TechnologyStack ts : category.getTechnologyStack()){
					ObjectNode node = mapper.createObjectNode();
					node.put("id", ts.getId());
					node.put("subcategory", ts.getName());
					node.put("categoryId", category.getId());
					subCategories.add(node);
					
			}
		}
		
		result.setResult(subCategories);
		result.setMessage("success");
		result.setStatus(0);
				
		return new ResponseEntity<RESTResult>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = { "/search_cat_skills" }, method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity<RESTResult> searchSkill(ModelMap model, @RequestParam("scId") String subCategoryId) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		RESTResult result = new RESTResult();		
		List<SkillSet> skillSets = categoryService.searchSkills(Long.parseLong(subCategoryId));		
		List<ObjectNode> subCategories = new ArrayList<ObjectNode>();
		if (skillSets != null){
			for(SkillSet ss : skillSets){
					ObjectNode node = mapper.createObjectNode();
					node.put("id", ss.getId());
					node.put("skillName", ss.getName());
					subCategories.add(node);
					
			}
		}
		
		result.setResult(subCategories);
		result.setMessage("success");
		result.setStatus(0);
				
		return new ResponseEntity<RESTResult>(result, HttpStatus.OK);
	}

}
