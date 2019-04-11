FROM mongo:latest
WORKDIR /home
COPY data/auth.js .
COPY data/shops.json .
COPY data/cities.json .
COPY import.sh .
RUN ["chmod","+x","import.sh"] 
CMD ["./import.sh"]
