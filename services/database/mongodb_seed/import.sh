#!/bin/bash
chmod +x /wait
/wait 
mongoimport --host mongodb -u root -p root --authenticationDatabase admin --db masterdata --collection cities --file cities.json
mongoimport --host mongodb -u root -p root --authenticationDatabase admin --db masterdata --collection shops --file shops.json
mongo --host mongodb -u root -p root --authenticationDatabase admin < auth.js
