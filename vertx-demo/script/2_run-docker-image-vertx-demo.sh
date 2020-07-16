#!/bin/bash

command="docker run -d --name vertx-demo -p 8081:8080 ibm-cloud-academy/vertx-demo:v1"
echo $command
$command