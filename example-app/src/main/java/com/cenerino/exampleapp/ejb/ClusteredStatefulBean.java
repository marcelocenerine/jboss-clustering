package com.cenerino.exampleapp.ejb;

import javax.ejb.Stateful;

import org.jboss.ejb3.annotation.Clustered;

@Stateful
@Clustered
public class ClusteredStatefulBean {

    public String hello() {
        return "Greetings from stateful bean deployed on node " + System.getProperty("jboss.node.name");
    }
}
