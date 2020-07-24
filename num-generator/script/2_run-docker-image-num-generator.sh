#!/bin/bash

command="docker run -d --name num-generator -p 8086:8080 ibm-cloud-academy/num-generator:v1"
echo $command
$command