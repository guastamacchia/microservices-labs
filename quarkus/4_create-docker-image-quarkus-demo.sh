#!/bin/bash

command="cd quarkus-demo"
echo $command
$command

command="./mvnw clean compile package"
echo $command
$command

command="docker build -f src/main/docker/Dockerfile.jvm -t ibm-cloud-academy/quarkus-demo:v1 ."
echo $command
$command