FROM amazoncorretto:17-alpine-jdk 
MAINTAINER RocioLosasso
COPY target/rbl-0.0.1-SNAPSHOT.jar    rbl-app.jar
ENTRYPOINT ["java","-jar","/rbl-app.jar"]
