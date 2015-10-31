# jboss-clustering
Cluster-enabled 'hello world' application (web/ejb) deployed on multiple jboss-eap servers. There are two setups using different load balancers: httpd + mod_cluster and the other
HAProxy. Everything runs within Docker containers.

Steps:

1. Spin up a VM using Vagrant (skip it if your firewall is disabled. As JBoss uses multicast to communicate with other members of the cluster (as well as the httpd modcluster), you may come across issues if the firewall is enabled)
2. run "mvn clean install" to build the Docker images
3. Go to "docker-compose" folder and run "docker-compose up -d" from within one of the two sub folders (choose which one you want to play with first)
4. Access the app URLs

URLs:
- http://localhost:9980/example-app/rest/hello
- http://localhost:9980/example-app/stateless/hello
- http://localhost:9980/example-app/stateful/hello

mod_cluster_manager:
- localhost:9966/mod_cluster_manager

haproxy stats:
- http://localhost:9936/


# TODOs:
- HAproxy doesn't stick with a new server when there is a failover. If option "redispatch" is used then a new JSESSIONID is created and the former session gets lost;
- HAproxy doesn't set the status of server that crashed and came up again with a different IP (Docker updates /etc/hosts correctly);
get updated with the new IP, hence the HAproxy thinks the server is still dead;