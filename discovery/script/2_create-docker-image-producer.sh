#!/bin/bash

command="cd .."
echo $command
$command

command="cd producer"
echo $command
$command

command="./mvnw clean compile package"
echo $command
$command

command="docker build -t ibm-cloud-academy/producer:v1 ."
echo $command
$command