package com.cenerino.exampleapp.ejb;

import javax.ejb.Local;

@Local
public interface ClusteredStatefulBean {

    String hello();
}
