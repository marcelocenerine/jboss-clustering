package com.cenerino.exampleapp.ejb;

import javax.ejb.Remote;

@Remote
public interface ClusteredStatefulBeanRemote extends HelloBean {
}
