# -*- mode: ruby -*-
# vi: set ft=ruby :
Vagrant.configure(2) do |config|
  config.vm.box = "puphpet/centos65-x64"
  config.vm.provision :shell, path: "bootstrap.sh"
  config.vm.provider "virtualbox" do |v|
    v.memory = 4096
    v.cpus = 2
  end
  config.vm.synced_folder "/home/marcelo/dev/", "/vagrant/dev"
  config.vm.network :forwarded_port, guest: 80, host: 9980
  config.vm.network :forwarded_port, guest: 6666, host: 9966
end