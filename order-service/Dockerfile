FROM openjdk:11
COPY target/*.jar order-service.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=kubernetes","/order-service.jar"]