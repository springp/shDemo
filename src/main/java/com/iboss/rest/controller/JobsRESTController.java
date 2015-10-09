package com.iboss.rest.controller;

import java.io.IOException;

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

import com.iboss.bo.RESTResult;
import com.iboss.entity.Category;
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
	@ResponseBody
	public ResponseEntity<RESTResult> getSubCategory(ModelMap model, @RequestParam("cId") String categoryId) throws IOException {
		
		RESTResult result = new RESTResult();		
//		List<Category> cat = categoryService.findById(Long.parseLong(categoryId));		
//	
//		StringBuffer buffer = new StringBuffer();
//		buffer.append(" [");
//		for (Category category : cat) {
//			for(TechnologyStack ts : category.getTechnologyStack()){
//				buffer.append("{'id':" + ts.getId() + ", 'subcategory':" + ts.getName() + ", 'categoryId':" + category.getId() + "},");
//			}
//		}
//		
//		buffer.replace(buffer.length() - 1, buffer.length(), ",");
//		buffer.append(" ]");
		
		Category category = categoryService.findById(Long.parseLong(categoryId));		
	
		StringBuffer buffer = new StringBuffer();
		buffer.append(" [");
		if (category.getTechnologyStack() != null){
			for(TechnologyStack ts : category.getTechnologyStack()){
					buffer.append("{'id':" + ts.getId() + ", 'subcategory':" + ts.getName() + ", 'categoryId':" + category.getId() + "},");
			}
		}
		
		buffer.replace(buffer.length() - 1, buffer.length(), ",");
		buffer.append(" ]");
		
		result.setResult(buffer);
		result.setMessage("success");
		result.setStatus(0);
				
		return new ResponseEntity<RESTResult>(result, HttpStatus.OK);
	}

}
