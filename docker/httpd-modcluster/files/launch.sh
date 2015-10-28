#/bin/bash

# adjust the IP addresses for the mod_cluster
IPADDR=$(ip a s | sed -ne '/127.0.0.1/!{s/^[ \t]*inet[ \t]*\([0-9.]\+\)\/.*$/\1/p}')
sed -i "s/%BINDING_ADDRESS%/$IPADDR/g" /opt/jboss/httpd/httpd/conf/httpd.conf

# run apache
./opt/jboss/httpd/sbin/apachectl -D FOREGROUND
