#!/bin/bash
while true
do 
  curl --connect-timeout 1 -s 'http://localhost:8083/'
  sleep 1;
done
