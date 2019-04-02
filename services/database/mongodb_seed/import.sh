#!/bin/bash
mongoimport --host mongodb --db masterdata --collection cities --file cities.json
mongoimport --host mongodb --db masterdata --collection shops --file shops.json
