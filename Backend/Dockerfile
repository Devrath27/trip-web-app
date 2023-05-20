FROM openjdk:11.0.16-jre
EXPOSE 8080
COPY target/*.jar trip-docker.jar
ENTRYPOINT ["java", "-jar", "/trip-docker.jar"]