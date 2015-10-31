package com.cenerino.exampleapp;

import com.cenerino.exampleapp.ejb.ClusteredStatefulBeanRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ClusteredStatefulBeanClient {

    private static final String JNDI = "ejb:/example-app/ClusteredStatefulBeanImpl!com.cenerino.exampleapp.ejb.ClusteredStatefulBeanRemote?stateful";

    public static void main(String[] args) throws NamingException {
        System.out.println("Running clustered stateful bean client. Press 'CTRL+C' to stop\n");

        Context context = new InitialContext();

        try {
            ClusteredStatefulBeanRemote statefulBean = (ClusteredStatefulBeanRemote) context.lookup(JNDI);

            while (true) {
                System.out.println(statefulBean.hello());
                doWait(1000);
            }
        } finally {
            context.close();
        }
    }

    private static void doWait(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
    }
}
