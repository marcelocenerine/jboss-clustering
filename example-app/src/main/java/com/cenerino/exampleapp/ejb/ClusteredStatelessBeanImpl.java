package com.cenerino.exampleapp.ejb;

import javax.ejb.Stateless;

import org.jboss.ejb3.annotation.Clustered;

@Stateless
@Clustered
public class ClusteredStatelessBeanImpl {

    public String hello() {
        return "Greetings from stateless bean deployed on node " + System.getProperty("jboss.node.name");
    }
}
