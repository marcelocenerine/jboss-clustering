FROM       java:7-jdk
MAINTAINER Marcelo Cenerino <marcelocenerine@gmail.com>

ADD files/*.zip /tmp/
ENV JBOSS_HOME /opt/jboss/jboss-eap-6.4

# Unzip file
RUN unzip /tmp/jboss-eap-6.4.0.zip -d /opt/jboss && rm -rf /tmp/jboss-eap-*.zip

# Add admin user
RUN $JBOSS_HOME/bin/add-user.sh admin admin123$ --silent

# Add application user (remote EJB calls)
RUN $JBOSS_HOME/bin/add-user.sh -a appclient client123$ --silent

# Expose ports
EXPOSE 8080 8443 9990 9999 8009 9443 4447

# Add volume to externalize logs
VOLUME $JBOSS_HOME/standalone/log

ENTRYPOINT exec $JBOSS_HOME/bin/standalone.sh -c standalone-ha.xml -Djboss.bind.address=$(hostname -I) \
-Djboss.bind.address.management=$(hostname -I) -Djboss.node.name=node-$(hostname)
