#!/bin/bash
mongoimport --host mongodb -u root -p root --authenticationDatabase admin --db masterdata --collection cities --file cities.json
mongoimport --host mongodb -u root -p root --authenticationDatabase admin --db masterdata --collection shops --file shops.json
