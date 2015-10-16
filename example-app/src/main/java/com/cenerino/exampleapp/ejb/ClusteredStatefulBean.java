package com.cenerino.exampleapp.ejb;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;

import org.jboss.ejb3.annotation.Clustered;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateful
@Clustered
@SessionScoped
public class ClusteredStatefulBean {

    private static final Logger logger = LoggerFactory.getLogger(ClusteredStatefulBean.class);
    private int counter;

    public String hello() {
        logger.info("Counter now is -> {}", ++counter);
        return "Greetings from stateful bean deployed on node " + System.getProperty("jboss.node.name");
    }
}
