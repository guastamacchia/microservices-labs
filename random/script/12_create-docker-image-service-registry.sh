#!/bin/bash

command="cd .."
echo $command
$command

command="cd service-registry"
echo $command
$command

command="./mvnw clean compile package"
echo $command
$command

command="docker build -t ibm-cloud-academy/service-registry:v1 ."
echo $command
$command