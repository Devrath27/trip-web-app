FROM openjdk:11.0.16-jre
EXPOSE 8080
ADD target/trip-docker.jar trip-docker.jar
ENTRYPOINT ["java", "-jar", "/trip-docker.jar"]