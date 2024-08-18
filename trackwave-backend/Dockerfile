# Stage 1: Build the Java app
FROM maven:3.9.8-eclipse-temurin-21 AS build
WORKDIR /app
COPY src /app/src
COPY pom.xml /app
RUN mvn -f /app/pom.xml clean package -DskipTests

# Stage 2 Serve the Java app
FROM openjdk:21
ENV SERVICE_NAME=trackwave
WORKDIR /app

COPY --from=build /app/target/$SERVICE_NAME-*.jar ./
CMD java -jar $SERVICE_NAME-*.jar