#!/bin/bash

command="cd .."
echo $command
$command

command="docker-compose up -d --scale service-a=2 --scale service-b=2 --scale service-c=2 --scale service-d=2 --no-recreate --remove-orphans"
echo $command
$command