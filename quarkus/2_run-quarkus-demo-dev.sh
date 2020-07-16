#!/bin/bash

command="cd quarkus-demo"
echo $command
$command

command="./mvnw quarkus:dev"
echo $command
$command