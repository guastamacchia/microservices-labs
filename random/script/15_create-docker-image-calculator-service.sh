#!/bin/bash

command="cd .."
echo $command
$command

command="cd calculator-service"
echo $command
$command

command="./mvnw clean compile package"
echo $command
$command

command="docker build -t ibm-cloud-academy/calculator-service:v1 ."
echo $command
$command