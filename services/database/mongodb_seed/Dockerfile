FROM mongo:latest
COPY data/shops.json /home/
COPY data/cities.json /home/
COPY import.sh /home/
#RUN ["chmod", "+x", "/home/import.sh"]
#ENV MONGO_INITDB_ROOT_USERNAME=mongo
#ENV MONGO_INITDB_ROOT_PASSWORD=mongo
#CMD mongoimport --host mongodb --db masterdata --collection cities --file /home/cities.json
CMD ["/bin/bash", "-c", "source /home/import.sh"]
