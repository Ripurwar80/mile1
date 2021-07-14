FROM java:openjdk-8-jre-alpine

WORKDIR /home

COPY target/*.jar /home

ENTRYPOINT ["/home/control.sh"]
