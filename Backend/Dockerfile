#FROM openjdk:11.0.16-jre
#EXPOSE 8080
#COPY target/*.jar trip-docker.jar
#ENTRYPOINT ["java", "-jar", "/trip-docker.jar"]

#
# Build stage
#
FROM maven:3.8.2-jdk-11 AS build
COPY . .
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM openjdk:11-jdk-slim
COPY --from=build /target/Backend-0.0.1-SNAPSHOT.jar demo.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]