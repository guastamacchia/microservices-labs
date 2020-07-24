#!/bin/bash

command="cd .."
echo $command
$command

command="cd service-a"
echo $command
$command

command="./mvnw clean compile package"
echo $command
$command

command="docker build -t ibm-cloud-academy/service-a:v1 ."
echo $command
$command

command="cd .."
echo $command
$command

command="cd service-b"
echo $command
$command

command="./mvnw clean compile package"
echo $command
$command

command="docker build -t ibm-cloud-academy/service-b:v1 ."
echo $command
$command

command="cd .."
echo $command
$command

command="cd service-c"
echo $command
$command

command="./mvnw clean compile package"
echo $command
$command

command="docker build -t ibm-cloud-academy/service-c:v1 ."
echo $command
$command

command="cd .."
echo $command
$command

command="cd service-d"
echo $command
$command

command="./mvnw clean compile package"
echo $command
$command

command="docker build -t ibm-cloud-academy/service-d:v1 ."
echo $command
$command