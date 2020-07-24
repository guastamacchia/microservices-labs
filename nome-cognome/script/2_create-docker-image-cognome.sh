#!/bin/bash

command="cd .."
echo $command
$command

command="cd cognome"
echo $command
$command

command="./mvnw clean compile package"
echo $command
$command

command="docker build -f src/main/docker/Dockerfile.jvm -t ibm-cloud-academy/cognome:v1 ."
echo $command
$command

