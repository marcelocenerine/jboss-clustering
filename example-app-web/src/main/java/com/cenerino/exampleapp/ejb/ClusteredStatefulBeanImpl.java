package com.cenerino.exampleapp.ejb;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;

import org.jboss.ejb3.annotation.Clustered;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateful
@Clustered
@SessionScoped
public class ClusteredStatefulBeanImpl implements ClusteredStatefulBean, ClusteredStatefulBeanRemote {

    private static final Logger logger = LoggerFactory.getLogger(ClusteredStatefulBeanImpl.class);
    private int counter;

    @Override
    public String hello() {
        String message = "Greetings from stateful bean deployed on node '" + System.getProperty("jboss.node.name") + "'. Counter -> " + counter++;
        logger.info(message);
        return message;
    }
}
