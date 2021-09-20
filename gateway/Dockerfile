FROM openjdk:11
COPY target/*.jar gateway.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=kubernetes","/gateway.jar"]