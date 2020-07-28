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

command="docker build -t ibm-cloud-academy/service-a:v2 ."
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

command="docker build -t ibm-cloud-academy/service-b:v2 ."
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

command="docker build -t ibm-cloud-academy/service-c:v2 ."
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

command="docker build -t ibm-cloud-academy/service-d:v2 ."
echo $command
$command

command="cd .."
echo $command
$command

command="cd api-gateway"
echo $command
$command

command="./mvnw clean compile package"
echo $command
$command

command="docker build -t ibm-cloud-academy/api-gateway:v2 ."
echo $command
$command

command="cd .."
echo $command
$command

command="cd hystrix-dashboard"
echo $command
$command

command="./mvnw clean compile package"
echo $command
$command

command="docker build -t ibm-cloud-academy/hystrix-dashboard:v2 ."
echo $command
$command

command="cd .."
echo $command
$command

command="cd service-registry"
echo $command
$command

command="./mvnw clean compile package"
echo $command
$command

command="docker build -t ibm-cloud-academy/service-registry:v2 ."
echo $command
$command