#!/bin/bash

command="cd .."
echo $command
$command

command="docker-compose up -d"
echo $command
$command