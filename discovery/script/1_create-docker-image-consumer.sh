#!/bin/bash

command="cd .."
echo $command
$command

command="cd consumer"
echo $command
$command

command="./mvnw clean compile package"
echo $command
$command

command="docker build -t ibm-cloud-academy/consumer:v1 ."
echo $command
$command