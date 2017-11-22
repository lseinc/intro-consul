#!/bin/bash

HOST=${1:-`hostname`}
SERVICE=${2:-"demo-consul-service"}

echo dig $HOST.node.consul  @localhost -p 8600
dig $HOST.node.consul  @localhost -p 8600

echo dig $SERVICE.service.consul  @localhost -p 8600
dig $SERVICE.service.consul  @localhost -p 8600
