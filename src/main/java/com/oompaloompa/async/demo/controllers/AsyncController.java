package com.oompaloompa.async.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.oompaloompa.async.demo.db.SlowProcessingDB;

@RestController
@RequestMapping("/defferedresult")
public class AsyncController {
	
	@Autowired
	SlowProcessingDB slowProcessingDB;

	@GetMapping
	@RequestMapping("/feedme")
	public DeferredResult<String> sendResponse(){
		DeferredResult<String> response = new DeferredResult<>();
		slowProcessingDB.slowProcessing(response);
		System.out.println("Gave task to a slow processing DB. I can perform IOTS");
		return response;
	}
	
}
