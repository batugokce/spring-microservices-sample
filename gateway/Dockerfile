FROM openjdk:17-alpine
COPY target/*.jar gateway.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=kubernetes","/gateway.jar"]