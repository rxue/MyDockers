# What
This project is making use of *Docker* to do some practical work on *MongoDB*
## Plan
Some reference data is going to be stored in *MongoDB*


# Task Description
## Docker Commands for Installing and Running *MongoDB*
1. [`docker pull mongo`](https://hub.docker.com/_/mongo/) - download Docker image of *MongoDB* from Docker Hub
2. `docker run -it -d mongo` - start this Docker Container
3. `docker exec -it e535fbd779b7 bash` - login to the Bash of this Docker Container with the image ID

## How to import json data to MongoDB Docker container in Windows
PC `docker exec mydockers_mongo_1 /usr/bin/mongoimport --db masterdata --collection shops --file /home/shops.json`
