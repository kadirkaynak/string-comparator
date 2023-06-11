FROM maven:3.6.3-openjdk-17-slim as maven-image
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]