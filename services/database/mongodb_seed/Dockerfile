FROM mongo:latest
WORKDIR /home
COPY data/auth.js .
COPY data/shops.json .
COPY data/cities.json .
COPY import.sh .
ADD https://github.com/ufoscout/docker-compose-wait/releases/download/2.2.1/wait /wait
CMD ["/bin/bash", "-c", "source import.sh"]
