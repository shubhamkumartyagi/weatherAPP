FROM openjdk:8-jre-alpine
WORKDIR /
ADD target/weatherAPP-0.0.1-SNAPSHOT.jar weatherAPP-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD java -jar weatherAPP-0.0.1-SNAPSHOT.jar
