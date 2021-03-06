#!/bin/bash

DIR=`dirname $0`
DIR=`cd $DIR;pwd`


mkdir -p $DIR/data

$DIR/consul \
	agent \
	-server \
	-bootstrap-expect=1 \
	-bind 127.0.0.1 \
	-data-dir $DIR/data \
	-ui

