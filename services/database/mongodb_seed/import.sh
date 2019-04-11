#!/bin/bash
# While until connecting to mongodb succeeds
# refer to: https://docs.docker.com/compose/startup-order/
while [ -n "$(mongo --host mongodb -u root -p root --authenticationDatabase admin --eval "quit()" |grep "Connection refused")" ]; 
do
  sleep 1
done
mongo --host mongodb -u root -p root --authenticationDatabase admin --eval "quit()" |grep "Connection refused"
mongoimport --host mongodb -u root -p root --authenticationDatabase admin --db masterdata --collection cities --file cities.json
mongoimport --host mongodb -u root -p root --authenticationDatabase admin --db masterdata --collection shops --file shops.json
mongo --host mongodb -u root -p root --authenticationDatabase admin < auth.js
