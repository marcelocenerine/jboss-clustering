#!/usr/bin/env bash

# Disable firewall to prevent issues with multicasting
echo "Disabling firewall..."
sudo service iptables save
sudo service iptables stop
sudo chkconfig iptables off

echo "Installing Docker..."
sudo wget -qO- https://get.docker.com/ | sh
sudo usermod -aG docker vagrant
sudo service docker restart

echo "Installing Docker Compose..."
sudo curl -L https://github.com/docker/compose/releases/download/1.5.0rc1/docker-compose-`uname -s`-`uname -m` > /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose

echo "Installing JDK..."
sudo yum install -y java-1.7.0-openjdk-devel

echo "Installing Maven..."
curl http://mirrors.whoishostingthis.com/apache/maven/maven-3/3.3.3/binaries/apache-maven-3.3.3-bin.tar.gz | sudo tar -xz -C /usr/local/
sudo ln -s /usr/local/apache-maven-3.3.3/bin/mvn /usr/bin/mvn
export M2_HOME=/usr/local/apache-maven-3.3.3

echo "Bootstrap done!"