package com.cenerino.exampleapp;

import com.cenerino.exampleapp.ejb.ClusteredStatelessBeanRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

import static javax.naming.Context.URL_PKG_PREFIXES;

public class ClusteredStatelessBeanClient {

    private static final String JNDI = "ejb:/example-app/ClusteredStatelessBeanImpl!com.cenerino.exampleapp.ejb.ClusteredStatelessBeanRemote";

    public static void main(String[] args) throws NamingException {
        System.out.println("Running clustered stateless bean client. Press 'CTRL+C' to stop\n");

        Properties prop = new Properties();
        prop.put(URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        Context context = new InitialContext(prop);
        ClusteredStatelessBeanRemote statelessBean = (ClusteredStatelessBeanRemote) context.lookup(JNDI);

        while (true) {
            System.out.println(statelessBean.hello());
            doWait(1000);
        }
    }

    private static void doWait(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) { }
    }
}
