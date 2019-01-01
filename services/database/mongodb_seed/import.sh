#!/bin/bash
mongoimport --host mongodb --db masterdata --collection cities --file /home/cities.json
mongoimport --host mongodb --db masterdata --collection shops --file /home/shops.json
