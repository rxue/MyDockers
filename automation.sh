#!/bin/bash
mvn -f my-rest-api/pom.xml clean package
if [ -d my-rest-api/logs ]; then 
  sudo rm -rf my-rest-api/logs 
fi
docker-compose up -d --build tomcat 
