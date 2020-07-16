#!/bin/bash

command="docker run -d --name quarkus-demo -p 8084:8080 ibm-cloud-academy/quarkus-demo:v1"
echo $command
$command