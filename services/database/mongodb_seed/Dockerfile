FROM mongo:latest
WORKDIR /home
COPY data/auth.js .
COPY data/shops.json .
COPY data/cities.json .
COPY import.sh .
#ENV MONGO_INITDB_ROOT_USERNAME=mongo
#ENV MONGO_INITDB_ROOT_PASSWORD=mongo
#CMD mongoimport --host mongodb --db masterdata --collection cities --file /home/cities.json
CMD ["/bin/bash", "-c", "source import.sh"]
