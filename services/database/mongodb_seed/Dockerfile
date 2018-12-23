FROM mongo:latest
COPY shops.json /home/
#RUN ["chmod", "+x", "/home/import.sh"]
#ENV MONGO_INITDB_ROOT_USERNAME=mongo
#ENV MONGO_INITDB_ROOT_PASSWORD=mongo
CMD mongoimport --host mongodb --db masterdata --collection shops --file /home/shops.json
