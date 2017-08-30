package com.oompaloompa.async.demo.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.oompaloompa.async.demo.controllers.AsyncResource;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        registerEndpoints();
    }
    private void registerEndpoints() {
         register(AsyncResource.class);
    }
}