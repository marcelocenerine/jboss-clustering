package com.cenerino.exampleapp.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.cenerino.exampleapp.ejb.ClusteredStatelessBean;

@Path("/hello")
public class HelloRest {

    @Inject
    private ClusteredStatelessBean statelessBean;

    @GET
    public String hello() {
        return statelessBean.hello();
    }
}
