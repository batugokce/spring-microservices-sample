FROM openjdk:17-alpine
COPY target/*.jar customer-service.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=kubernetes", "/customer-service.jar"]