#!/bin/bash

#set -x
echo curl -s -X POST http://localhost:8080/application/refresh -o-
RESULT=`curl -s -X POST http://localhost:8080/application/refresh -o-`

printf "result=$RESULT\n"
