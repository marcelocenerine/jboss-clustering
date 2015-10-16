package com.cenerino.exampleapp.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.cenerino.exampleapp.ejb.HelloStateless;

@Path("/hello")
public class HelloService {

    @Inject
    private HelloStateless bean;

    @GET
    public String hello() {
        return bean.hello();
    }
}
