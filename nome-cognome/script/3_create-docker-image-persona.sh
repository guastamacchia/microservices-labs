#!/bin/bash

command="cd .."
echo $command
$command

command="cd persona"
echo $command
$command

command="./mvnw clean compile package"
echo $command
$command

command="docker build -t ibm-cloud-academy/persona:v1 ."
echo $command
$command