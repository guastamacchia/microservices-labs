#!/bin/bash
while true
do 
  curl --connect-timeout 1 -s 'http://localhost:8080/chaining'
  sleep 1;
  echo
done
