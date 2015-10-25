#!/usr/bin/env bash

# Disable firewall
sudo service iptables save
sudo service iptables stop
sudo chkconfig iptables off

# Install Docker
sudo wget -qO- https://get.docker.com/ | sh
sudo usermod -aG docker vagrant
sudo service docker restart


