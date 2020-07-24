#!/bin/bash
while true
do 
  curl --connect-timeout 1 -s 'http://localhost:8087/persona'
  sleep 1;
  echo
done
