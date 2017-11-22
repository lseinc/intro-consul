#!/bin/bash

OS=`uname -s`

if [ "$OS" = "Darwin" ];
then
  curl https://releases.hashicorp.com/consul/1.0.0/consul_1.0.0_darwin_amd64.zip -o consul_1.0.0_darwin_amd64.zip
else
  curl https://releases.hashicorp.com/consul/1.0.0/consul_1.0.0_linux_amd64.zip -o consul_1.0.0_linux_amd64.zip
fi


