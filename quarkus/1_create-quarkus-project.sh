#!/bin/bash

command="mvn io.quarkus:quarkus-maven-plugin:1.6.0.Final:create -DprojectGroupId=com.ibm.cloud.academy -DprojectArtifactId=quarkus-demo -DprojectVersion=1.0 -DclassName=com.ibm.cloud.academy.MainResource"
echo $command
$command