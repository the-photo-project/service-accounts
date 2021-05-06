# syntax=docker/dockerfile:1

# This builds a full Java JDK container.  It is used to build the application
# using maven which is then created as a jar file in the /app/target directory.
# Uses OpenJDK version 11 from https://openjdk.java.net/
# Uses Maven version 3 from https://maven.apache.org/
#
# See here: https://hub.docker.com/_/maven for information on the tags we
# can use in the FROM line to get the version of Maven.

# Build instructions:
#
# Pull an image from DockerHub https://hub.docker.com/ which has already been
# built using the versions of Maven and OpenJDK that we want.
#
# Copy our working directory into /app on the container.
#
# Use mvn to build our app.

FROM maven:3-openjdk-11 AS build
RUN mkdir /app
COPY . /app
WORKDIR /app
RUN mvn clean package -DskipTests

# This builds a minimal container just containing the JRE (Java Runtime, no Java
# development kit, no compiler). It is just enough to run our application.
#
# We use OpenJDK version 11 JRE and the Hotspot JVM from the adoptopenjdk project.
# See https://adoptopenjdk.net/

# Build instructions:
#
# Pull an image from dockerhub which already has the JRE.
# See https://hub.docker.com/_/adoptopenjdk
#
# Copy the pre-built JAR file from the build container (above, which has already
# run the JDK to compile the app into a jar file).
#
# Run the app using "java" in the container.

FROM adoptopenjdk:11-jre-hotspot AS prod
RUN mkdir -p /app/target
COPY --from=build /app/target/service-accounts-1.0.0-SNAPSHOT.jar /app/target
WORKDIR /app/target
CMD ["java", "-jar", "/app/target/service-accounts-1.0.0-SNAPSHOT.jar"]
