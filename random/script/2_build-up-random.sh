#!/bin/bash

command="cd .."
echo $command
$command

command="docker-compose up -d --scale calculator-service=2 --scale num-generator-service=2 --scale op-generator-service=2 --no-recreate --remove-orphans"
echo $command
$command