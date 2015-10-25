package com.cenerino.exampleapp.ejb;

import javax.ejb.Stateless;

import org.jboss.ejb3.annotation.Clustered;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
@Clustered
public class ClusteredStatelessBean {

    private static final Logger logger = LoggerFactory.getLogger(ClusteredStatelessBean.class);

    public String hello() {
        String message = "Greetings from stateless bean deployed on node '" + System.getProperty("jboss.node.name") + "'";
        logger.info(message);
        return message;
    }
}
