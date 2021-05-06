# syntax=docker/dockerfile:1

FROM maven:3-openjdk-11 AS build
RUN mkdir /app
COPY . /app
WORKDIR /app
RUN mvn clean package -DskipTests

FROM adoptopenjdk:11-jre-hotspot AS prod
RUN mkdir -p /app/target
COPY --from=build /app/target/service-accounts-1.0.0-SNAPSHOT.jar /app/target
WORKDIR /app/target
CMD ["java", "-jar", "/app/target/service-accounts-1.0.0-SNAPSHOT.jar"]
