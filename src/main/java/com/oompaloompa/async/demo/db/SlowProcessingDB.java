package com.oompaloompa.async.demo.db;

import javax.ws.rs.container.AsyncResponse;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

@Component
public class SlowProcessingDB {

	@Async
	public void slowProcessing(DeferredResult<String> response) {
		// TODO Auto-generated method stub
		
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		response.setResult("Oh Boy I am damn slow!!! Fix me :-/");
	}

	@Async
	public void slowProcessing(AsyncResponse response) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		response.resume("Oh Boy I am damn slow!!! Fix me :-/ - Your's JAX-RS");
	}

}
