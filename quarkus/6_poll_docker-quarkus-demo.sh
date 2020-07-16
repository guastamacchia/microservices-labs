#!/bin/bash
while true
do 
  curl --connect-timeout 1 -s 'http://localhost:8084/hello'
  sleep 1;
  echo
  curl --connect-timeout 1 -s 'http://localhost:8084/hello/Francesco'
  sleep 1;
  echo
done
