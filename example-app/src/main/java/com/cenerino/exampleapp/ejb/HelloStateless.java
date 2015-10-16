package com.cenerino.exampleapp.ejb;

import javax.ejb.Stateless;

import org.jboss.ejb3.annotation.Clustered;

@Stateless
@Clustered
public class HelloStateless {

    public String hello() {
        return "Greetings from " + System.getProperty("jboss.node.name");
    }
}
