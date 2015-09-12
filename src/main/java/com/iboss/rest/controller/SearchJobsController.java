package com.iboss.rest.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iboss.bo.RESTResult;
import com.iboss.entity.User;

@RestController
@RequestMapping("/api")
public class SearchJobsController {

	@RequestMapping(value = { "/search_jobs" }, method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE }, produces = {MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<RESTResult> searchData(ModelMap model, @RequestBody User user) throws IOException {
		RESTResult result = new RESTResult();
		return new ResponseEntity<RESTResult>(result, HttpStatus.OK);
	}

}
