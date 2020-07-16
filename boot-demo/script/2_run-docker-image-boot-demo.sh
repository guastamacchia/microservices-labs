#!/bin/bash

command="docker run -d --name boot-demo -p 8082:8080 ibm-cloud-academy/boot-demo:v1"
echo $command
$command