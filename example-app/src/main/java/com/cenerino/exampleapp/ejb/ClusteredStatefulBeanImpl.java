package com.cenerino.exampleapp.ejb;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import org.jboss.ejb3.annotation.Clustered;

@Stateful
@Clustered
@EJB(name = "ejb/stateful", beanInterface = ClusteredStatefulBean.class)
public class ClusteredStatefulBeanImpl implements ClusteredStatefulBean {

    @Override
    public String hello() {
        return "Greetings from stateful bean deployed on node " + System.getProperty("jboss.node.name");
    }
}
