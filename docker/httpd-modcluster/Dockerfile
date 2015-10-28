FROM       centos:latest
MAINTAINER Marcelo Cenerino <marcelocenerine@gmail.com>

RUN curl http://downloads.jboss.org/mod_cluster/1.2.6.Final/linux-x86_64/mod_cluster-1.2.6.Final-linux2-x64.tar.gz | tar -xz -C /

ADD files/httpd.conf /opt/jboss/httpd/httpd/conf/
ADD files/launch.sh /
RUN chmod +x launch.sh

# Expose ports
EXPOSE 80 6666

ENTRYPOINT /launch.sh





