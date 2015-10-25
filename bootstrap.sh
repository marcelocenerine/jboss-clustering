#!/usr/bin/env bash

# Disable firewall
sudo service iptables save
sudo service iptables stop
sudo chkconfig iptables off

# Install Docker
sudo wget -qO- https://get.docker.com/ | sh
sudo usermod -aG docker vagrant
sudo service docker restart

# Install Docker Compose
sudo curl -L https://github.com/docker/compose/releases/download/1.5.0rc1/docker-compose-`uname -s`-`uname -m` > /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose
