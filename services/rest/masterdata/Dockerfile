FROM tomcat:latest
COPY target/masterdata.war /usr/local/tomcat/webapps/
ENV JPDA_ADDRESS=8000
ENV JPDA_TRANSPORT=dt_socket
ENTRYPOINT ["catalina.sh", "jpda", "run"]

