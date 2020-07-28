FROM openjdk:8-jdk-slim

ENV APP_HOME /demo

RUN mkdir $APP_HOME
ADD ./target/*.jar $APP_HOME/app.jar

WORKDIR $APP_HOME

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]