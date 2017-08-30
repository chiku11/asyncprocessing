package com.oompaloompa.async.demo.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import com.oompaloompa.async.demo.db.SlowProcessingDB;

@Component
@Path("/jaxrsdefferedresult")
@Produces("application/json")
@Async
public class AsyncResource {
	
	@Autowired
	SlowProcessingDB slowProcessingDB;
	
	@GET
	@Path("/feedmedeffer")
	public DeferredResult<String> sendResponseDeferr(){
		DeferredResult<String> response = new DeferredResult<>();
		slowProcessingDB.slowProcessing(response);
		System.out.println("Gave task to a slow processing DB. I can perform IOTS");
		return response;
	}
	
	@GET
	@Path("/feedmeasync")
	public void sendResponseAsync(@Suspended AsyncResponse response){
		slowProcessingDB.slowProcessing(response);
		System.out.println("Gave task to a slow processing DB. I can perform IOTS");
		//return response;
	}
}
